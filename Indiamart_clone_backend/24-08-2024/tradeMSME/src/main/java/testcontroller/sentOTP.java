package testcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import entity.buisnessdetailsent;
import entity.buyerprofilee;
import otputil.otputil;
import service.EmailService;
import service.buisnessdetailsservice;
import service.buissnessdetailsadditionalservice;
import service.buyerprofileservice;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class sentOTP {

	@Autowired
	private buyerprofileservice buyerprofilservice;
	
	@Autowired
	private buisnessdetailsservice buisnesdetailsservice;
	
	@Autowired
	private EmailService emailservice;
	
	 private Map<String, String> otpStore = new HashMap<>();
	
	 
	 //for buyer
    @GetMapping("/send-otp/{mobilenumber}")
	public ResponseEntity<?> sendOtpToSeller(@PathVariable String mobilenumber) {
    	  buyerprofilee user = buyerprofilservice.getUserByMobileNumber(mobilenumber);
    	  if (user == null) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
          }
    	  
    	  String email = user.getEmail();
    	  
    	  if (email == null || email.isEmpty()) {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email ID not found for this user");
          }
    	  
    	  String otp = otputil.generateOTP(4);
    	  otpStore.put(mobilenumber, otp);
    	  
    	  try {
    	        emailservice.sendOtpEmail(email, otp); // Call the updated email function
    	        return ResponseEntity.ok("OTP sent successfully to " + email);
    	    } catch (Exception e) {
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    	                .body("Failed to send OTP email: " + e.getMessage());
    	    }
	}
    
    
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        String otp = request.get("otp");

        if (otpStore.containsKey(mobileNumber) && otpStore.get(mobileNumber).equals(otp)) {
            otpStore.remove(mobileNumber); // Remove OTP after successful verification
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }
    
    //for seller
    
    
    @GetMapping("/sendotp/{mobilenumber}")
  	public ResponseEntity<?> sendOtpTobuissness(@PathVariable String mobilenumber) {
      	  buisnessdetailsent user = buisnesdetailsservice.getBusinessDetails(mobilenumber);
      	  if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
      	  
      	  String email = user.getEmailaddress();
      	  
      	  if (email == null || email.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email ID not found for this user");
            }
      	  
      	  String otp = otputil.generateOTP(4);
      	  otpStore.put(mobilenumber, otp);
      	  
      	  try {
      	        emailservice.sendOtpEmail(email, otp); // Call the updated email function
      	        return ResponseEntity.ok("OTP sent successfully to " + email);
      	    } catch (Exception e) {
      	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
      	                .body("Failed to send OTP email: " + e.getMessage());
      	    }
  	}
    
    
    @PostMapping("/verifyotp")
    public ResponseEntity<?> verifyOtpbuisness(@RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        String otp = request.get("otp");

        if (otpStore.containsKey(mobileNumber) && otpStore.get(mobileNumber).equals(otp)) {
            otpStore.remove(mobileNumber); // Remove OTP after successful verification
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }
    
}
