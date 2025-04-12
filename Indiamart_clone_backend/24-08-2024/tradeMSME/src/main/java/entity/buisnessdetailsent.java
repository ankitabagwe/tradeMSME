package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class buisnessdetailsent {


@Id
	private String mobilenumber;
	private String name;
	private String companydetails;
	private String emailaddress;
	private String Pincode;
	private String City;
	private String State;
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
		return "buisnessdetailsent [mobilenumber=" + mobilenumber + ", name=" + name + ", companydetails="
				+ companydetails + ", emailaddress=" + emailaddress + ", Pincode=" + Pincode + ", City=" + City
				+ ", State=" + State + "]";
	}
	public buisnessdetailsent(String mobilenumber, String name, String companydetails, String emailaddress,
			String pincode, String city, String state) {
		super();
		this.mobilenumber = mobilenumber;
		this.name = name;
		this.companydetails = companydetails;
		this.emailaddress = emailaddress;
		this.Pincode = pincode;
		City = city;
		State = state;
	}
	public buisnessdetailsent() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	 
	
	
}
