package rf.claim.repository.pojo;

import rf.claim.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhouzheng on 2017/5/1.
 */
@Entity
@Table(name = "T_NOTICE_OF_LOSS")
public class TNoticeOfLoss extends BaseEntity {

    @Id
    private String uuid;
    private String noticeNumber;
    private String policyNumber;
    private Date accidentTime;
    private Date noticeTime;
    private String accidentCause;
    private String accidentDescription;
    @Lob
    private String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
