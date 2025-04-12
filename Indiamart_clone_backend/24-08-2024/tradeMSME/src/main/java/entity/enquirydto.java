package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class enquirydto {

	@Id
	private int id;
    private String quantity;
    private String requirementDetails;
    private String gstNumber;
    private String userMobileNumber;
    private String productName;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRequirementDetails() {
		return requirementDetails;
	}
	public void setRequirementDetails(String requirementDetails) {
		this.requirementDetails = requirementDetails;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public String toString() {
		return "enquirydto [id=" + id + ", quantity=" + quantity + ", requirementDetails=" + requirementDetails
				+ ", gstNumber=" + gstNumber + ", userMobileNumber=" + userMobileNumber + ", productName=" + productName
				+ "]";
	}
	public enquirydto(int id, String quantity, String requirementDetails, String gstNumber, String userMobileNumber,
			String productName) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.requirementDetails = requirementDetails;
		this.gstNumber = gstNumber;
		this.userMobileNumber = userMobileNumber;
		this.productName = productName;
	}
	public enquirydto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
	
	
}
