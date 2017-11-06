package rf.claim.repository.pojo;


import rf.claim.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhouzheng on 2017/5/1.
 */
@Entity
@Table(name = "T_CLAIM")
public class TClaim extends BaseEntity {

    @Id
    private String uuid;
    private String claimNumber;
    private String productCode;
    private String statusCode;
    private String policyNumber;
    private Date accidentTime;
    private Date claimTime;
    @Lob
    private String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
