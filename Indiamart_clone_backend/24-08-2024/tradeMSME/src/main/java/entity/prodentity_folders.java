package entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class prodentity_folders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productname;
	private String price;
	private String productdescription;
	private String filepath; 
	private String youtubelink;
	private String pdffilepath;
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
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getYoutubelink() {
		return youtubelink;
	}
	public void setYoutubelink(String youtubelink) {
		this.youtubelink = youtubelink;
	}
	public String getPdffilepath() {
		return pdffilepath;
	}
	public void setPdffilepath(String pdffilepath) {
		this.pdffilepath = pdffilepath;
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
		return "prodentity_folders [id=" + id + ", productname=" + productname + ", price=" + price
				+ ", productdescription=" + productdescription + ", filepath=" + filepath + ", youtubelink="
				+ youtubelink + ", pdffilepath=" + pdffilepath + ", shippingoption=" + shippingoption + ", taxoption="
				+ taxoption + ", mobilenumber=" + mobilenumber + "]";
	}
	public prodentity_folders(int id, String productname, String price, String productdescription, String filepath,
			String youtubelink, String pdffilepath, String shippingoption, String taxoption, String mobilenumber) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.productdescription = productdescription;
		this.filepath = filepath;
		this.youtubelink = youtubelink;
		this.pdffilepath = pdffilepath;
		this.shippingoption = shippingoption;
		this.taxoption = taxoption;
		this.mobilenumber = mobilenumber;
	}
	public prodentity_folders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
 
	
}
