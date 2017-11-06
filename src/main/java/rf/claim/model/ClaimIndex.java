package rf.claim.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhouzheng on 2017/5/18.
 */
public class ClaimIndex {
    /**
     * 理赔号
	 */
    private String claimNumber;
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 理赔状态
     */
    private String status;
    /**
     * 保单号
     */
    private String policyNumber;
    /**
     * 出险时间
     */
    private Date accidentTime;
    /**
     * 理赔申请时间
     */
    private Date claimTime;
    /**
     * 理赔申请人
     */
    private String claimant;
    /**
     * payment amount of loss indemnity
     * 赔款
     */
    private BigDecimal paymentAmount;
    /**
     * 理赔申请金额
     */
    private BigDecimal claimAmount;
    /**
     * 结案日期
     */
    private Date closeDate;

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public Date getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(Date accidentTime) {
        this.accidentTime = accidentTime;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public String getClaimant() {
        return claimant;
    }

    public void setClaimant(String claimant) {
        this.claimant = claimant;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }
}
