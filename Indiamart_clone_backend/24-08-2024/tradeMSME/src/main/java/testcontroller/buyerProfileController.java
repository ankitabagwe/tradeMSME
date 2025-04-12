package testcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import entity.buyerprofilee;
import service.buyerprofileservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class buyerProfileController {

	@Autowired
	private buyerprofileservice buyerprofservice;
	
	@PostMapping("/userprofile")
	@CrossOrigin(origins = "http://localhost:4200")
	 public ResponseEntity<String> registerBuyer(@RequestBody buyerprofilee profile) {
		System.out.println(profile);
		buyerprofservice.saveProfile(profile);
	        return ResponseEntity.ok("Profile saved successfully!");
	    }
	

	@GetMapping("/details/{mobileNumber}")
	public ResponseEntity<?> getUserDetailsByMobileNumber(@PathVariable String mobileNumber) {
		buyerprofilee user = buyerprofservice.getUserByMobileNumber(mobileNumber);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
	
	

	
//	  @GetMapping("/details/{mobilenumber}")
//	    public ResponseEntity<?> getUserDetailsByMobileNumber(@PathVariable String mobilenumber) {
//	        Optional<buyerprofilee> user = buyerprofservice.getUserByMobileNumber(mobilenumber);
//	        if (user.isPresent()) {
//	            return ResponseEntity.ok(user.get());
//	        } else {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//	        }
//	    }
		
//		@GetMapping("/details/{mobilenumber}")
//		public ResponseEntity<?> getUserDetailsByMobileNumber(@PathVariable String mobilenumber) {
//			BuyerProfile user = buyerprofservice.getUserByMobileNumber(mobilenumber);
//	        if (user != null) {
//	        	 System.out.println("Mobile Number Found: " + mobilenumber);
//	            return ResponseEntity.ok(user);
//	        } else {
//	        	System.out.println("Mobile Number Not Found: " + mobilenumber);
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//	        }
//	    }
	
	
}
