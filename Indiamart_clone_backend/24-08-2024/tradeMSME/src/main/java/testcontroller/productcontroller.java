package testcontroller;

import java.io.Console;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import entity.prodentity_folders;
import entity.product_base64;
import entity.productbuisnessdto;
import service.prodbase64service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/productdetails")
public class productcontroller {

	@Autowired
	private prodbase64service service;
	
	@PostMapping("/addproducts")
	 public ResponseEntity<String> addproduct(@RequestBody product_base64 base64) {
//		System.out.println(base64);
		if (base64.getMobilenumber() == null || base64.getMobilenumber().isEmpty()) {
	        throw new IllegalArgumentException("Mobile number is required");
	    }
	        try {
	            // Use the service to save the product
	        	service.saveProduct(base64);
	         System.out.println("at controller:: \"Product submitted successfully\"");
	            return ResponseEntity.ok("Product submitted successfully");
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.ok( "Product submitted successfully");
	        }
	    }
	

	
//	@CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/getProducts")
//	public ResponseEntity<List<product_base64>> getProductwithImage(@RequestParam String productname){
//		try {
//         List<product_base64> product = service.fetchProductWithImage(productname);
//            return ResponseEntity.ok(product);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }	
//	}
	
	@GetMapping("/ping3")
	 public String getProductsByName2() {
	   return "pong2";
	 }
	
	//trial
	 @GetMapping("/search")
	 public ResponseEntity<?> getProductsByName(@RequestParam(required = false) String productname) {
	     try {
	         List<productbuisnessdto> products = service.fetchProductWithImage(productname); // Passing null for city
	         if (products.isEmpty()) {
	             return ResponseEntity.ok("No Products Found");
	         }
	         return ResponseEntity.ok(products);
	     } catch (IOException e) {
	         e.printStackTrace();
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                 .body("Error occurred while fetching product images");
	     }
	 }

//	 @GetMapping("/search")
//	 public ResponseEntity<?> getProductsByName(@RequestParam(required = false) String productname) {
//	     try {
//	         List<product_base64> products = service.fetchProductWithImage(productname); // Passing null for city
//	         if (products.isEmpty()) {
//	             return ResponseEntity.ok("No Products Found");
//	         }
//	         return ResponseEntity.ok(products);
//	     } catch (IOException e) {
//	         e.printStackTrace();
//	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                 .body("Error occurred while fetching product images");
//	     }
//	 }
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/search")
//	public ResponseEntity<List<product_base64>> searchProducts(
//            @RequestParam(required = false) String productname,
//            @RequestParam(required = false) String city) {
//		try {
//	        List<product_base64> results;
//
//	        if (productname != null || city != null) {
//	            // Call the service method with both parameters, where the missing one can be null
//	            results = service.fetchProductWithImage(productname, city != null && city.equals("null") ? null : city);
//	        } else {
//	            throw new IllegalArgumentException("At least one of 'name' or 'city' must be provided.");
//	        }
//
//	        return ResponseEntity.ok(results);
//
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                .body(Collections.emptyList()); // Empty list for errors
//	    }
//    }

	 //trial
	 @GetMapping("/random")
	 @CrossOrigin(origins = "http://localhost:4200")
	 public ResponseEntity<List<productbuisnessdto>> getRandomProducts(@RequestParam(defaultValue = "5") int limit) {
	        try {
	            // Call the service to fetch random products with Base64 images
	            List<productbuisnessdto> products = service.getRandomProducts(limit);

	            return ResponseEntity.ok(products); // Return the products as a JSON response
	        } catch (Exception  e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
	        }
	    }
//	 
//	 @GetMapping("/random")
//	 @CrossOrigin(origins = "http://localhost:4200")
//	 public ResponseEntity<List<product_base64>> getRandomProducts(@RequestParam(defaultValue = "5") int limit) {
//	        try {
//	            // Call the service to fetch random products with Base64 images
//	            List<product_base64> products = service.getRandomProducts(limit);
//
//	            return ResponseEntity.ok(products); // Return the products as a JSON response
//	        } catch (Exception  e) {
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
//	        }
//	    }

	 @GetMapping("/getproductbymobile/{mobilenumber}")
	 @CrossOrigin(origins = "http://localhost:4200")
	 public ResponseEntity<List<product_base64>> getProductsByMobile(@PathVariable String mobilenumber) {
		    try {
		        List<product_base64> products = service.getProductsByMobile(mobilenumber);
		        
		        if (products.isEmpty()) {
		            return ResponseEntity.ok(Collections.emptyList());
		        }

		        return ResponseEntity.ok(products);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
		    }
		}
	 
	 @DeleteMapping("deleteproduct/{id}")
	 public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		 try {
		        boolean deleted = service.deleteProductById(id);
		        if (deleted) {
		            return ResponseEntity.ok("Product deleted successfully");
		        } else {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting product");
		    }
	 }
	
}
