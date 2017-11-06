package rf.claim.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rf.claim.repository.pojo.TClaim;

import java.util.List;

/**
 * Created by zhouzheng on 2017/5/1.
 */
public interface ClaimDao extends CrudRepository<TClaim, String> {

    @Query("SELECT m FROM #{#entityName} m WHERE m.claimNumber=:claimNumber")
    TClaim findByClaimNumber(@Param("claimNumber") String claimNumber);

    @Query("SELECT m FROM #{#entityName} m WHERE m.policyNumber=:policyNumber")
    List<TClaim> findByPolicyNumber(@Param("policyNumber") String policyNumber);

    /**
     * 根据保单号，获取已经结案的理赔信息，并按照时间倒序排序
     * @param policyNumber
     * @return
     */
    @Query("SELECT m FROM #{#entityName} m WHERE m.policyNumber=:policyNumber and m.statusCode ='CLOSE' order by creationTime desc")
    List<TClaim> findValidClosedClaimByPolicyNumber(@Param("policyNumber") String policyNumber);

    /**
     * 根据保单号，获取未结案的理赔信息
     * @param policyNumber
     * @return
     */
    @Query("SELECT m FROM #{#entityName} m WHERE m.policyNumber=:policyNumber and m.statusCode = 'OPEN' ")
    List<TClaim> findOpenClaimByPolicyNumber(@Param("policyNumber") String policyNumber);
}
