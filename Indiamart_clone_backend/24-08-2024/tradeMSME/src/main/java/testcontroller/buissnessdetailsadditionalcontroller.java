package testcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.buissnessdetailsadditional;
import service.buissnessdetailsadditionalservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sellerupdateadditional")
public class buissnessdetailsadditionalcontroller {

	@Autowired
	private buissnessdetailsadditionalservice buissnessadditionalservice;
	
	@PutMapping("/{mobilenumber}")
	 public ResponseEntity<String> upsertBusinessDetails(@PathVariable String mobilenumber, @RequestBody buissnessdetailsadditional details) {
		 details.setMobilenumber(mobilenumber);
		 buissnessdetailsadditional savedDetails = buissnessadditionalservice.upsertBusinessDetails(details);
		 if (savedDetails != null) {
	            return ResponseEntity.ok("Business details updated successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving business details!");
	        }
	 }
	
	
	  @GetMapping("updateadditional/{mobilenumber}")
	    public ResponseEntity<buissnessdetailsadditional> getBusinessDetails(@PathVariable String mobilenumber) {
	    	buissnessdetailsadditional details = buissnessadditionalservice.getBusinessDetailsByMobile(mobilenumber);
	        if (details != null) {
	            return ResponseEntity.ok(details);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
