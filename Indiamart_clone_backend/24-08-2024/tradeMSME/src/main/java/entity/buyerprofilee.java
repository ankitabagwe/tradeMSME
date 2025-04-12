package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class buyerprofilee {
	@Id
    @Column(nullable = false, length = 10, unique = true)
    private String mobilenumber; // Primary key

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 6)
    private String pincode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String companyname;

    @Column(nullable = false)
    private String gstin;

    @Column(nullable = false)
    private String pan;

    @Column(nullable = false)
    private String ifsccode;

    @Column(nullable = false)
    private String accountnumber;

    @Column(nullable = false)
    private String bankname;

    @Column(nullable = false)
    private String accounttype;

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	@Override
	public String toString() {
		return "buyerprofilee [mobilenumber=" + mobilenumber + ", name=" + name + ", email=" + email + ", pincode="
				+ pincode + ", city=" + city + ", companyname=" + companyname + ", gstin=" + gstin + ", pan=" + pan
				+ ", ifsccode=" + ifsccode + ", accountnumber=" + accountnumber + ", bankname=" + bankname
				+ ", accounttype=" + accounttype + "]";
	}

	public buyerprofilee(String mobilenumber, String name, String email, String pincode, String city,
			String companyname, String gstin, String pan, String ifsccode, String accountnumber, String bankname,
			String accounttype) {
		super();
		this.mobilenumber = mobilenumber;
		this.name = name;
		this.email = email;
		this.pincode = pincode;
		this.city = city;
		this.companyname = companyname;
		this.gstin = gstin;
		this.pan = pan;
		this.ifsccode = ifsccode;
		this.accountnumber = accountnumber;
		this.bankname = bankname;
		this.accounttype = accounttype;
	}

	public buyerprofilee() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
