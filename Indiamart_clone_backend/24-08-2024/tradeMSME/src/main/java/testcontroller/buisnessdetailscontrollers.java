package testcontroller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import entity.buisnessdetailsent;
import entity.gstpandetails;
import service.buisnessdetailsservice;
import service.gstservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class buisnessdetailscontrollers {
	
	@Autowired
	private buisnessdetailsservice Buisnessdetailsservice;
	
	@Autowired
	private gstservice servicegst;
	
	
	@PostMapping("/buisnessdetails")
	public buisnessdetailsent getbuisnessdetails( @RequestBody buisnessdetailsent e) {
		 System.out.println("Received: " + e);
	return Buisnessdetailsservice.SaveDetails(e);
	
	}
	
	@PostMapping("/gstdetails")
	public gstpandetails getgstdetails( @RequestBody gstpandetails e) {
		 System.out.println("Received: " + e);
	return servicegst.SaveDetails(e);
	
	}
	
	//to check if seller registered
	 @GetMapping("/checkMobileNumber")
	    public ResponseEntity<Boolean> checkMobileNumber(@RequestParam String mobilenumber) {
	        boolean isRegistered = Buisnessdetailsservice.isMobileNumberRegistered(mobilenumber);
	        return ResponseEntity.ok(isRegistered);
	    }
	
//	 @GetMapping("/buissnessdetails/{mobilenumber}")
//		public ResponseEntity<?> getsellerDetailsByMobileNumber(@PathVariable String mobilenumber) {
//			buisnessdetailsent user = Buisnessdetailsservice.getUserBymobilenumber(mobilenumber);
//	        if (user != null) {
//	            return ResponseEntity.ok(user);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User1 not found");
//	        }
//	    }
	 
	 @GetMapping("getbuissnessdata/{mobilenumber}")
	    public ResponseEntity<buisnessdetailsent> getBusinessDetails(@PathVariable String mobilenumber) {
	        return ResponseEntity.ok(Buisnessdetailsservice.getBusinessDetails(mobilenumber));
	    }
	    
	    @PutMapping("/sellerupdate/{mobilenumber}")
	    public ResponseEntity<?> updateBusinessDetails(@PathVariable String mobilenumber, @RequestBody buisnessdetailsent updatedDetails) {
	    	   buisnessdetailsent existingDetails = Buisnessdetailsservice.getBusinessDetails(mobilenumber);
	    	   
	    	   if (existingDetails != null) {
	    		   existingDetails.setName(updatedDetails.getName());
	    		   existingDetails.setCompanydetails(updatedDetails.getCompanydetails());
	    		   existingDetails.setEmailaddress(updatedDetails.getEmailaddress());
	    		   existingDetails.setMobilenumber(updatedDetails.getMobilenumber());
	    		   existingDetails.setCity(updatedDetails.getCity());
	    		   existingDetails.setState(updatedDetails.getState());
	    		   existingDetails.setPincode(updatedDetails.getPincode());
	    		   
	    		   Buisnessdetailsservice.SaveDetails(existingDetails);
	    		   return ResponseEntity.ok("Business details updated successfully!");
	    	   }
	    	   else {
	    	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Business details not found for mobile number: " + mobilenumber);
	    	    }
	    	   
	    }
	
}
