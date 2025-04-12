package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class product_base64 {
  
	

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
	@Override
	public String toString() {
		return "product_base64 [id=" + id + ", productname=" + productname + ", price=" + price
				+ ", productdescription=" + productdescription + ", file=" + file + ", youtubelink="
				+ youtubelink + ", pdffile=" + pdffile + ", shippingoption=" + shippingoption + ", taxoption="
				+ taxoption + ", mobilenumber=" + mobilenumber + "]";
	}
	public product_base64(int id, String productname, String price, String productdescription, String filepath,
			String youtubelink, String pdffilepath, String shippingoption, String taxoption, String mobilenumber) {
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
	}
	public product_base64() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	
}
