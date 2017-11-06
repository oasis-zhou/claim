package rf.claim.ds.impl;


import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rf.claim.ds.ClaimService;
import rf.claim.exception.GenericException;
import rf.claim.model.Claim;
import rf.claim.model.ClaimIndex;
import rf.claim.model.ClaimQueryCondition;
import rf.claim.repository.ClaimDao;
import rf.claim.repository.pojo.TClaim;
import rf.claim.utils.JsonHelper;

import java.util.*;

/**
 * Created by zhouzheng on 2017/5/1.
 */
@Service
public class ClaimServiceImpl implements ClaimService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClaimDao claimDao;

    @Autowired
    private JsonHelper jsonHelper;


    /**
     * 生成理赔，主要是生成一条新的理赔记录，产生理赔单号
     * 并且读取保单的部分信息
     * 申请人设置为投保人
     *
     * @param claim
     * @return
     */
    @Transactional
    @Override
    public Claim createClaim(Claim claim) {
        TClaim po = claimDao.findByClaimNumber(claim.getClaimNumber());

        if(po == null) {
            po = new TClaim();
        }else{
            //理赔号已存在
            throw new GenericException(40000L);
        }
        Date date = new Date();
        //生成新的理赔号
//        if(po.getClaimNumber() == null){
//            Map<NumberingFactor, String> factors = new HashMap<NumberingFactor, String>();
//            factors.put(NumberingFactor.TRANS_YEAR, new SimpleDateFormat("yyyy").format(date));
//            String claimNumber = numberingService.generateNumber(NumberingType.CLAIM_NUMBER,factors);
//            claim.setClaimNumber(claimNumber);
//        }else{
//            throw new GenericException(40000L);
//        }
        BeanUtils.copyProperties(claim, po);

        //BaseEntity中对创建时间、修改时间有初始化为当前时间
        //po.setCreationTime(date);
        //后续更改获取方法
        if(claim.getOperator()!=null&&claim.getOperator().length()>0){
            po.setCreatedBy(claim.getOperator());
            po.setModifiedBy(claim.getOperator());
        }else{
            //防止没有取到操作人信息的情况
            po.setCreatedBy("system");
            po.setModifiedBy("system");
        }
        po.setStatusCode(claim.getStatus().name());

        String content = jsonHelper.toJSON(claim);
        po.setContent(content);
        logger.debug("准备新建理赔:"+claim.getClaimNumber());
        claimDao.save(po);
        return claim;
    }

    @Override
    public void saveClaim(Claim claim) {
        TClaim po = claimDao.findByClaimNumber(claim.getClaimNumber());
        if(po == null) {
            //理赔号不存在异常
            throw new GenericException(40001L);
        }
        claim.setUuid(po.getUuid());
        claim.setClaimTime(po.getClaimTime());
        claim.setProductCode(po.getProductCode());

        Date date = new Date();
        BeanUtils.copyProperties(claim, po,new String[]{"uuid"});
        po.setStatusCode(claim.getStatus().name());
        //更新修改日期
        po.setModificationTime(date);
        if(claim.getOperator()!=null&&claim.getOperator().length()>0){
            po.setModifiedBy(claim.getOperator());
        }else{
            //后续更改获取方法
            po.setModifiedBy("system");
        }
        String content = jsonHelper.toJSON(claim);
        po.setContent(content);
        logger.debug("begin to save claim");
        claimDao.save(po);
    }

    @Override
    public void closeClaim(Claim claim) {

    }

    @Override
    public Claim loadClaim(String claimNumber) {
        TClaim po = claimDao.findByClaimNumber(claimNumber);

        Claim claim = null;
        if(po != null) {
            claim = jsonHelper.fromJSON(po.getContent(), Claim.class);
        }

        return claim;
    }


    @Override
    public List<Claim> findClaimsByPolicyNumber(String policyNumber) {
        List<TClaim> list = claimDao.findByPolicyNumber(policyNumber);
        List<Claim> result = Lists.newArrayList();
        if(list!=null&&list.size()>0){
            for(TClaim tc:list){
                result.add(jsonHelper.fromJSON(tc.getContent(), Claim.class));
            }
        }
        return result;
    }


    /**
     * 根据录入条件，查询出数据结果，并且只查询有效的保单
     * @param condition
     * @return
     */
    public List<ClaimIndex> findClaims(ClaimQueryCondition condition){
        //PREPARE属于中间状态，还未生成报案，故不允许在查询中展示
        String sql = "select * from t_claim as p  where p.status!='PREPARE' ";

        List<ClaimIndex> indexs = Lists.newArrayList();

        List <Object> queryConditions=new ArrayList<Object>();
        if (condition.getPolicyNumber() != null && !condition.getPolicyNumber().equals("")) {
            sql += " and p.policyNumber = ? ";
            queryConditions.add(condition.getPolicyNumber());
        }
        if (condition.getProductCode() != null && !condition.getProductCode().equals("")) {
            sql += " and p.productCode = ? ";
            queryConditions.add(condition.getProductCode());
        }
        if (condition.getClaimNumber() != null && !condition.getClaimNumber().equals("")) {
            sql += " and p.claimNumber = ? ";
            queryConditions.add(condition.getClaimNumber());
        }
        if (condition.getStatus() != null && !condition.getStatus().equals("")) {
            sql += " and p.statusCode = ? ";
            queryConditions.add(condition.getStatus());
        }
        if(condition.getClaimTimeStart()!=null){
            sql += " and p.claimTime > ? ";
            queryConditions.add(condition.getClaimTimeStart());
        }
        if(condition.getClaimTimeEnd()!=null){
            sql += " and p.claimTime < ? ";
            queryConditions.add(condition.getClaimTimeEnd());
        }
        indexs = jdbcTemplate.query(sql,queryConditions.toArray(),new BeanPropertyRowMapper(ClaimIndex.class));

        return indexs;
    }

    /**
     * 根据保单号，获取最新的理赔数据信息
     * @param policyNumber
     * @return
     */
    public Claim findLatestClaimByPolicyNumber(String policyNumber){
        List<TClaim> list = claimDao.findValidClosedClaimByPolicyNumber(policyNumber);
        if(list!=null&&list.size()>0){
            for(TClaim tclaim:list){
                Claim claim = jsonHelper.fromJSON(tclaim.getContent(), Claim.class);
                //由于查询条件按照日期倒序排列，只需要获取到第一条即可
                    return claim;
                }
        }
        //如果数据库没有查到已结案理赔，返回空
        return null;
    }

    /**
     * LiRui add
     * 根据保单号，获取未结案的数据信息
     * @param policyNumber
     * @return
     */
    public List<Claim> findOpenClaimsByPolicyNumber(String policyNumber){
        List<TClaim> list = claimDao.findOpenClaimByPolicyNumber(policyNumber);
        List<Claim> result = Lists.newArrayList();
        if(list!=null&&list.size()>0){
            for(TClaim tc:list){
                result.add(jsonHelper.fromJSON(tc.getContent(), Claim.class));
            }
        }
        return result;
    }
}
