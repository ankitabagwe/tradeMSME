//package testcontroller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import entity.BuyerProfile;
//import entity.enquirydto;
//import entity.prodentity_folders;
//import service.inquiryService;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class enquirycontroller {
//	
//	@Autowired
//	private inquiryService inquiryservice;
//	
//	@PostMapping("/sendtoseller")
//	 public ResponseEntity<String> createInquiry(@RequestBody enquirydto inquiryDto) {
//		
//	        inquiryservice.processAndSendInquiry(inquiryDto);
//
////	        // Send inquiry details to the seller
////	        inquiryservice.sendInquiryToSeller(inquiryDto);
//
//	        return ResponseEntity.ok("Inquiry submitted successfully.");
//	    }
//	
//	 @GetMapping("/getSellerInquiries")
//	    public ResponseEntity<List<Map<String, Object>>> getSellerInquiries(@RequestParam String sellerMobileNumber) {
//	        List<Map<String, Object>> inquiries = inquiryservice.getInquiriesForSeller(sellerMobileNumber);
//	        if (inquiries.isEmpty()) {
//	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(inquiries);  // No inquiries found
//	        }
//	        return ResponseEntity.ok(inquiries);  // Return the list of inquiries
//	    }
//	 
//	 
//	 
//	 @PostMapping("/sendtobuyleads")
//	 public ResponseEntity<?> sendToBuyLeads(@RequestBody Map<String, Object> request) {
//	        String query = (String) request.get("query"); // Matches "query" from frontend
//	        String mobileNumber = (String) request.get("mobileNumber"); // Matches "mobileNumber" from frontend
//
//	        // Call the service to find sellers and notify them
////	        List<prodentity_folders> sellercontactnumber = inquiryservice.findSellersByProduct(query);
////	        System.out.println("seller contact info "+sellercontactnumber);
//	        
////	        boolean isSellerMatch = sellercontactnumber.stream()
//	                .anyMatch(seller -> seller.getMobileNumber().equals(mobileNumber));
//
//	        if (!isSellerMatch) {
//	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Seller not authorized to view this product's buyers.");
//	        }
//	        
//	        
//	       BuyerProfile buyer = inquiryservice.findBuyerDetailsByMobileNumber(mobileNumber);
//	       
//	        System.out.println("buyer  info "+buyer.getName() + buyer.getMobileNumber() + buyer.getEmail());
//	        
////	        inquiryservice.notifySellers(sellers, mobileNumber);
//
//	        // Return sellers' data or other response as required
//	        	
//	        Map<String, Object> response = new HashMap<>();
//	        response.put("buyers", buyer);  // Add the list of buyers to the response
//	        response.put("sellers", sellercontactnumber);  // Add the seller contact numbers to the response
//
//	        
//	        // Return the response with both buyers and sellers data
//	        return ResponseEntity.ok(response);
//	 
//	 }
//	
//
//}
