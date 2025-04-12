package entity;

import jakarta.persistence.Column;

public class productbuisnessdto {

	private int id;
	private String productname;
	private String price;
	private String productdescription; 
	private String file; 
	private String youtubelink;
	private String pdffile;
	private String shippingoption;
	private String taxoption;
	@Column(nullable = false)
	private String mobilenumber;
	private String name;
	private String companydetails;
	private String emailaddress;
	private String Pincode;
	private String City;
	private String State;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getYoutubelink() {
		return youtubelink;
	}
	public void setYoutubelink(String youtubelink) {
		this.youtubelink = youtubelink;
	}
	public String getPdffile() {
		return pdffile;
	}
	public void setPdffile(String pdffile) {
		this.pdffile = pdffile;
	}
	public String getShippingoption() {
		return shippingoption;
	}
	public void setShippingoption(String shippingoption) {
		this.shippingoption = shippingoption;
	}
	public String getTaxoption() {
		return taxoption;
	}
	public void setTaxoption(String taxoption) {
		this.taxoption = taxoption;
	}
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
	public String getCompanydetails() {
		return companydetails;
	}
	public void setCompanydetails(String companydetails) {
		this.companydetails = companydetails;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	@Override
	public String toString() {
		return "productbuisnessdto [id=" + id + ", productname=" + productname + ", price=" + price
				+ ", productdescription=" + productdescription + ", file=" + file + ", youtubelink=" + youtubelink
				+ ", pdffile=" + pdffile + ", shippingoption=" + shippingoption + ", taxoption=" + taxoption
				+ ", mobilenumber=" + mobilenumber + ", name=" + name + ", companydetails=" + companydetails
				+ ", emailaddress=" + emailaddress + ", Pincode=" + Pincode + ", City=" + City + ", State=" + State
				+ "]";
	}
	public productbuisnessdto(int id, String productname, String price, String productdescription, String file,
			String youtubelink, String pdffile, String shippingoption, String taxoption, String mobilenumber,
			String name, String companydetails, String emailaddress, String pincode, String city, String state) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.productdescription = productdescription;
		this.file = file;
		this.youtubelink = youtubelink;
		this.pdffile = pdffile;
		this.shippingoption = shippingoption;
		this.taxoption = taxoption;
		this.mobilenumber = mobilenumber;
		this.name = name;
		this.companydetails = companydetails;
		this.emailaddress = emailaddress;
		Pincode = pincode;
		City = city;
		State = state;
	}
	public productbuisnessdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
