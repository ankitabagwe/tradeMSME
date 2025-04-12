package service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.buyerprofilee;
import repository.Buyerprofilerepo;

@Service
public class buyerprofileservice {

	@Autowired
	private Buyerprofilerepo buyerprofilerepo;
	
	public buyerprofilee saveProfile(buyerprofilee profile) {
	
		return buyerprofilerepo.save(profile);
		
	}
	
//	 public Optional<buyerprofilee> getUserByMobileNumber(String mobilenumber) {
//	        return buyerprofilerepo.findBymobilenumber(mobilenumber);
//	    }
	 
	 public buyerprofilee getUserByMobileNumber(String mobileNumber) {
	        return buyerprofilerepo.findBymobilenumber(mobileNumber);
	    }
	 
//	public BuyerProfile getUserByMobileNumber(String mobilenumber) {
//        System.out.println("Searching for: " + mobilenumber);
//        return buyerprofilerepo.findByMobilenumber(mobilenumber);
//
//    }
	
}
