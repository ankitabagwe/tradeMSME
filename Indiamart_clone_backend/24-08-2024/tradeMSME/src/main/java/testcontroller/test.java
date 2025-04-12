package testcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import entity.productbuisnessdto;


@RestController
public class test {

	@CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/ping")
	 public String getProductsByName() {
	   return "pong";
	 }
	 
	
	 @GetMapping("/ping2")
	 public String getProductsByName2() {
	   return "pong2";
	 }
}
