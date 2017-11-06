package rf.claim.model;

import rf.claim.model.enums.RejectReason;

import java.math.BigDecimal;

/**
 * @auther zhouzheng
 * @Date 2017/9/17
 */
public class ClaimItem extends ModelComponent{

	/**
	 * indemnityAmount=reserveAmount + paymentAmount - subrogationAmount
	 * 赔偿总额(=准备金+赔款-追偿款)
	 */
	private BigDecimal indemnityAmount;
	/**
	 * payment amount of loss indemnity
	 * 赔款，实际赔付金额
	 */
	private BigDecimal paymentAmount;
	/**
	 * outstanding reserve amount
	 * 准备金
	 */
	private BigDecimal reserveAmount;
	/**
	 * subrogation amount
	 * 追偿款
	 */
	private BigDecimal subrogationAmount;
	private String coverageName;
	private String coverageCode;
	/**
	 * 理算金额
	 */
	private BigDecimal claimAmount;

	/**
	 * 拒赔原因
	 */
	private RejectReason rejectReason;

	/**
	 * 申请金额，带有免赔额的保险责任时，记录本次扣除的免赔额
	 */
	private BigDecimal applicationAmount;

	public BigDecimal getIndemnityAmount() {
		return indemnityAmount;
	}
	public void setIndemnityAmount(BigDecimal indemnityAmount) {
		this.indemnityAmount = indemnityAmount;
	}
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public BigDecimal getReserveAmount() {
		return reserveAmount;
	}
	public void setReserveAmount(BigDecimal reserveAmount) {
		this.reserveAmount = reserveAmount;
	}
	public BigDecimal getSubrogationAmount() {
		return subrogationAmount;
	}
	public void setSubrogationAmount(BigDecimal subrogationAmount) {
		this.subrogationAmount = subrogationAmount;
	}
	public String getCoverageName() {
		return coverageName;
	}
	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}
	public String getCoverageCode() {
		return coverageCode;
	}
	public void setCoverageCode(String coverageCode) {
		this.coverageCode = coverageCode;
	}
	public BigDecimal getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}
	public RejectReason getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(RejectReason rejectReason) {
		this.rejectReason = rejectReason;
	}
	public BigDecimal getApplicationAmount() {
		return applicationAmount;
	}
	public void setApplicationAmount(BigDecimal applicationAmount) {
		this.applicationAmount = applicationAmount;
	}

}