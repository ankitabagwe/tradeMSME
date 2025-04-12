package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.buissnessdetailsadditional;
import repository.buissnessdetailsadditionalrepo;

@Service
public class buissnessdetailsadditionalservice {

	@Autowired
	private buissnessdetailsadditionalrepo buissnessadditionalrepo;
	
	  public buissnessdetailsadditional upsertBusinessDetails(buissnessdetailsadditional details) {
		  Optional<buissnessdetailsadditional> existingDetails = buissnessadditionalrepo.findById(details.getMobilenumber());
		  if (existingDetails.isPresent()) {
			  buissnessdetailsadditional updatedDetails = existingDetails.get();
			  updatedDetails.setAccountholdername(details.getAccountholdername());
			  updatedDetails.setAccountnumber(details.getAccountnumber());
			  updatedDetails.setBankname(details.getBankname());
			  updatedDetails.setBranchname(details.getBranchname());
			  updatedDetails.setCinllpin(details.getCinllpin());
			  updatedDetails.setGstin(details.getGstin());
			  updatedDetails.setIfsc(details.getIfsc());
			  updatedDetails.setImportexportcode(details.getImportexportcode());
			  updatedDetails.setMobilenumber(details.getMobilenumber());
			  updatedDetails.setPan(details.getPan());
			  updatedDetails.setTan(details.getTan());
			  
			   return buissnessadditionalrepo.save(updatedDetails);
			  }
		  else {
	            // Insert new seller details
	            return buissnessadditionalrepo.save(details);
	        }
	  }
	  
	  
	  
	  public buissnessdetailsadditional getBusinessDetailsByMobile(String mobilenumber) {
	        return buissnessadditionalrepo.findBymobilenumber(mobilenumber);
	    }
}
