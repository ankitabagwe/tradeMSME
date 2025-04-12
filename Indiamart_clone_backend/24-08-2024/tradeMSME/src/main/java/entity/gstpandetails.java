package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class gstpandetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String gstNumber;
	
	private String panNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getpanNumber() {
		return panNumber;
	}

	public void setpanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	@Override
	public String toString() {
		return "gstpanNumberdetails [id=" + id + ", gstNumber=" + gstNumber + ", panNumber=" + panNumber + "]";
	}

	public gstpandetails(int id, String gstNumber, String panNumber) {
		super();
		this.id = id;
		this.gstNumber = gstNumber;
		this.panNumber = panNumber;
	}

	public gstpandetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
