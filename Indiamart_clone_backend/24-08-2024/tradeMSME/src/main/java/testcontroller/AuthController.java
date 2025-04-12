//package testcontroller;
//
//import java.io.Console;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import entity.buyerprofilee;
//import jakarta.servlet.http.HttpSession;
//import repository.Buyerprofilerepo;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
//public class AuthController {
//
//	@Autowired
//	private Buyerprofilerepo buyerprofilerepo;
//	
//	@PostMapping("/loginn")
//	@CrossOrigin(origins = "http://localhost:4200") 
//    public ResponseEntity<String> login(@RequestBody buyerprofilee loginRequest){
//		String mobileNumber = loginRequest.getMobilenumber();
//	
//		System.out.println(mobileNumber);
//		Optional<buyerprofilee> userOptional = buyerprofilerepo.findBymobilenumber(mobileNumber);
//		if (userOptional.isPresent()) {
//          
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mobile number not registered");
//        }
//		
//	}
//	
//	  @GetMapping("/check-session")
//	    public ResponseEntity<Boolean> checkSession(HttpSession session) {
//	        return ResponseEntity.ok(session.getAttribute("user") != null); // True if user is in session
//	    }
//	
//	
//	
//}
