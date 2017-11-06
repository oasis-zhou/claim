package rf.claim.model;

/**
 * @auther zhouzheng
 * @Date 2017/9/17
 */
public class Claimant extends ModelComponent{
	/* 姓名 */
	private String name;
	/* 证件类型 */
	private String idType;
	/* 证件号码 */
	private String idNumber;
	/* 账户类型 */
	private String accountType;
	/* 账户号码 */
	private String accountNumber;
	/* 账户名称 */
	private String accountName;
	/* 银行代码 */
	private String bankCode;
	/* 电子邮箱 */
	private String email;
	/* 手机号码 */
	private String mobile;
	/* 通讯地址 */
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Claimant{" +
				"name='" + name + '\'' +
				", idType='" + idType + '\'' +
				", idNumber='" + idNumber + '\'' +
				", accountType='" + accountType + '\'' +
				", accountNumber='" + accountNumber + '\'' +
				", accountName='" + accountName + '\'' +
				", bankCode='" + bankCode + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
