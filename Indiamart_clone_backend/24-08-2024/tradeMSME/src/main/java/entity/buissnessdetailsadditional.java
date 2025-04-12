package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class buissnessdetailsadditional {

	    @Id
	    @Column(unique = true, nullable = false)
	    private String mobilenumber; // Unique Identifier
	    private String gstin;
	    private String pan;
	    private String tan;
	    private String cinllpin;
	    private String importexportcode;

	    // Bank Details
	    private String accountnumber;
	    private String ifsc;
	    private String accountholdername;
	    private String branchname;
	    private String bankname;
		public String getMobilenumber() {
			return mobilenumber;
		}
		public void setMobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
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
		public String getTan() {
			return tan;
		}
		public void setTan(String tan) {
			this.tan = tan;
		}
		public String getCinllpin() {
			return cinllpin;
		}
		public void setCinllpin(String cinllpin) {
			this.cinllpin = cinllpin;
		}
		public String getImportexportcode() {
			return importexportcode;
		}
		public void setImportexportcode(String importexportcode) {
			this.importexportcode = importexportcode;
		}
		public String getAccountnumber() {
			return accountnumber;
		}
		public void setAccountnumber(String accountnumber) {
			this.accountnumber = accountnumber;
		}
		public String getIfsc() {
			return ifsc;
		}
		public void setIfsc(String ifsc) {
			this.ifsc = ifsc;
		}
		public String getAccountholdername() {
			return accountholdername;
		}
		public void setAccountholdername(String accountholdername) {
			this.accountholdername = accountholdername;
		}
		public String getBranchname() {
			return branchname;
		}
		public void setBranchname(String branchname) {
			this.branchname = branchname;
		}
		public String getBankname() {
			return bankname;
		}
		public void setBankname(String bankname) {
			this.bankname = bankname;
		}
		@Override
		public String toString() {
			return "buissnessdetailsadditional [mobilenumber=" + mobilenumber + ", gstin=" + gstin + ", pan=" + pan
					+ ", tan=" + tan + ", cinllpin=" + cinllpin + ", importexportcode=" + importexportcode
					+ ", accountnumber=" + accountnumber + ", ifsc=" + ifsc + ", accountholdername=" + accountholdername
					+ ", branchname=" + branchname + ", bankname=" + bankname + "]";
		}
		public buissnessdetailsadditional(String mobilenumber, String gstin, String pan, String tan, String cinllpin,
				String importexportcode, String accountnumber, String ifsc, String accountholdername, String branchname,
				String bankname) {
			super();
			this.mobilenumber = mobilenumber;
			this.gstin = gstin;
			this.pan = pan;
			this.tan = tan;
			this.cinllpin = cinllpin;
			this.importexportcode = importexportcode;
			this.accountnumber = accountnumber;
			this.ifsc = ifsc;
			this.accountholdername = accountholdername;
			this.branchname = branchname;
			this.bankname = bankname;
		}
		public buissnessdetailsadditional() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
}
