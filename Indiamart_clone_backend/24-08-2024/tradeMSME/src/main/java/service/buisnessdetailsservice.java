package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.buisnessdetailsent;
import repository.buisnessdetailsrepo;

@Service
public class buisnessdetailsservice {

	@Autowired
	private  buisnessdetailsrepo Buisnessdetailsrepo;
	
	public buisnessdetailsent SaveDetails(buisnessdetailsent e) {
		return Buisnessdetailsrepo.save(e);
	}
	
	public boolean isMobileNumberRegistered(String mobilenumber) {
        // Query the database to see if the mobile number exists
        return Buisnessdetailsrepo.existsBymobilenumber(mobilenumber);
    }
	
//	public buisnessdetailsent getUserBymobilenumber(String mobilenumber) {
//        return Buisnessdetailsrepo.findBymobilenumber(mobilenumber);
//    }
	
	  public buisnessdetailsent getBusinessDetails(String mobilenumber) {
	        return Buisnessdetailsrepo.findBymobilenumber(mobilenumber)
	                .orElseThrow(() -> new RuntimeException("Business details not found"));
	    }
}
