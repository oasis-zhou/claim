package rf.claim.model;

import insurance.fd.pub.Guid;

import java.util.Date;

public class NoticeOfLoss extends ModelComponent{

	private String noticeNumber;
	private String policyNumber;
	private Date accidentTime;
	private Date noticeTime;
	private String accidentCause;
	private String accidentDescription;
	private Claimant claimant;

	public NoticeOfLoss(){
		this.setUuid(Guid.generateStrId());
	}

	public String getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(String noticeNumber) {
		this.noticeNumber = noticeNumber;
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
	public Date getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}
	public String getAccidentCause() {
		return accidentCause;
	}
	public void setAccidentCause(String accidentCause) {
		this.accidentCause = accidentCause;
	}
	public String getAccidentDescription() {
		return accidentDescription;
	}
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	public Claimant getClaimant() {
		return claimant;
	}
	public void setClaimant(Claimant claimant) {
		this.claimant = claimant;
	}
	
}
