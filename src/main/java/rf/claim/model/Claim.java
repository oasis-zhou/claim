package rf.claim.model;

import rf.claim.model.enums.AccidentCause;
import rf.claim.model.enums.ClaimStatus;
import rf.claim.model.enums.RejectReason;
import rf.claim.pub.Guid;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @auther zhouzheng
 * @Date 2017/9/17
 */
public class Claim extends ModelComponent
{

	/**
	 * 理赔号
	 */
	private String claimNumber;
	/**
	 * 产品代码
	 */
	private String productCode;
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
	 * 出险原因
	 */
	private AccidentCause accidentCause;

	/**
	 * 事故描述
	 */
	private String accidentDescription;
	/**
	 * 业务数据
	 */
	private Map<String, Object> businessContent;
	/**
	 * 外部唯一标识
	 */
	private String referenceNumber;
	/**
	 * 索赔人信息
	 */
	private Claimant claimant;
	/**
	 * 理赔项目信息
	 */
	private List<ClaimItem> claimItems;
	/**
	 * 申请理赔金额
	 */
	private BigDecimal claimAmount;
	/**
	 * 支付理赔金额
	 */
	private BigDecimal paymentAmount;
	/**
	 * 备注信息
	 */
	private String memo;
	/**
	 * 操作人
	 */
	private String operator;

	/**
	 * 结案日期
	 */
	private Date closeDate;

	/**
	 * 事故日期
	 */
	private Date perilDate;

	/**
	 * 结案意见
	 */
	private String closingOpinion;

	/**
	 * 结案状态
	 */
	private ClaimStatus status;

	/**
	 * 拒赔原因
	 */
	private RejectReason rejectReason;

	/**
	 * 累计赔付次数，只包含有效赔付的次数，拒赔和新申请的理赔不算在内
	 */
	private int numberOfClaim;

	public Claim(){
		this.setUuid(Guid.generateStrId());
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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

	public AccidentCause getAccidentCause() {
		return accidentCause;
	}

	public void setAccidentCause(AccidentCause accidentCause) {
		this.accidentCause = accidentCause;
	}

	public String getAccidentDescription() {
		return accidentDescription;
	}

	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}

	public Map<String, Object> getBusinessContent() {
		return businessContent;
	}

	public void setBusinessContent(Map<String, Object> businessContent) {
		this.businessContent = businessContent;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public Claimant getClaimant() {
		return claimant;
	}

	public void setClaimant(Claimant claimant) {
		this.claimant = claimant;
	}

	public List<ClaimItem> getClaimItems() {
		if(this.claimItems==null){
			this.claimItems=new ArrayList<ClaimItem>();
		}
		return claimItems;
	}

	public void setClaimItems(List<ClaimItem> claimItems) {
		this.claimItems = claimItems;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getPerilDate() {
		return perilDate;
	}

	public void setPerilDate(Date perilDate) {
		this.perilDate = perilDate;
	}

	public String getClosingOpinion() {
		return closingOpinion;
	}

	public void setClosingOpinion(String closingOpinion) {
		this.closingOpinion = closingOpinion;
	}

	public int getNumberOfClaim() {
		return numberOfClaim;
	}

	public void setNumberOfClaim(int numberOfClaim) {
		this.numberOfClaim = numberOfClaim;
	}

	public ClaimStatus getStatus() {
		return status;
	}

	public void setStatus(ClaimStatus status) {
		this.status = status;
	}

	public RejectReason getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(RejectReason rejectReason) {
		this.rejectReason = rejectReason;
	}

	public BigDecimal getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
}