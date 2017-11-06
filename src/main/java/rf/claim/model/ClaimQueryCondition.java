package rf.claim.model;

import java.util.Date;

/**
 * Created by zhouzheng on 2017/5/24.
 * @ Date 2017-08-22 update LiRui 理算页面查询条件，增加“申请日期起”、“申请日期止”字段
 */
public class ClaimQueryCondition {
    /**
     * 保单号
     */
    private String policyNumber;
    /**
     * 理赔号
     */
    private String productCode;
    /**
     * 理赔号
     */
    private String claimNumber;
    /**
     * 理赔申请人
     */
    private String claimantName;
    /**
     * 理赔状态
     */
    private String status;
    /**
     * 申请日期起
     */
    private Date claimTimeStart;
    /**
     * 申请日期止
     */
    private Date claimTimeEnd;

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getClaimTimeStart() {
        return claimTimeStart;
    }

    public void setClaimTimeStart(Date claimTimeStart) {
        this.claimTimeStart = claimTimeStart;
    }

    public Date getClaimTimeEnd() {
        return claimTimeEnd;
    }

    public void setClaimTimeEnd(Date claimTimeEnd) {
        this.claimTimeEnd = claimTimeEnd;
    }
}
