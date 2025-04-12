package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.buisnessdetailsent;
import entity.prodentity_folders;
import entity.product_base64;
import entity.productbuisnessdto;
import repository.buisnessdetailsrepo;
import repository.prodrepo_folder;

@Service
public class prodbase64service {

	@Autowired
	private prodrepo_folder prodrepofolder;
	
	@Autowired
	private buisnessdetailsrepo buisnessdetailrepo;
	
//	@Autowired
//	private fetchrepo fetchrepository;
	
//	private final String folderpath = "C:\\Users\\AnkitaBagwe\\OneDrive - Adapt Fintech Advisors Private Limited\\Documents\\ankita\\Desktop\\Ankita_Project\\Indiamart\\Indiamart_clone_backend\\Products";
	
	private final String folderpath = "C:\\Users\\pavan\\Desktop\\tradeMSME-ankita\\Indiamart_clone_backend\\Products";
	
	 public prodentity_folders saveProduct(product_base64 base64) throws IOException {
		 
		 prodentity_folders prodentity64 = new prodentity_folders();
		 
		 prodentity64.setProductname(base64.getProductname());
		 prodentity64.setPrice(base64.getPrice());
		 prodentity64.setProductdescription(base64.getProductdescription());
		 prodentity64.setMobilenumber(base64.getMobilenumber());
		 prodentity64.setYoutubelink(base64.getYoutubelink());
		 prodentity64.setShippingoption(base64.getShippingoption());
		 prodentity64.setTaxoption(base64.getTaxoption());
		 
//		 prodentity64.setPdfFilepath(base64.getPdfFilepath()); 
		 
		 System.out.println("Mobile number received: " + base64.getMobilenumber());

		 if (base64.getFile() != null && base64.getFile().contains(",")) {
			    String[] parts = base64.getFile().split(",");
			    if (parts.length > 1) {
			        byte[] decodedBytes = Base64.getDecoder().decode(parts[1]);
			        String filePath = folderpath + "\\"+ System.currentTimeMillis() + ".png"; // Save with a unique name
			       System.out.println("storing image at" + filePath);
			        try (FileOutputStream fos = new FileOutputStream(filePath)) {
			            fos.write(decodedBytes);
			        }
			        catch (IOException e) {
			            e.printStackTrace();
			            throw new RuntimeException("Failed to write image file to the folder", e);
			        }
			        prodentity64.setFilepath(filePath);
			    } else {
			        throw new IllegalArgumentException("Invalid Base64 input, missing encoded data");
			    }
			} else {
			    throw new IllegalArgumentException("Base64 input is null or doesn't contain the expected format");
			}

		 //saving pdf
		 if(base64.getPdffile()!=null&& base64.getPdffile().contains(",")) {
			 String[] pdfParts = base64.getPdffile().split(",");
			 if (pdfParts.length > 1) {
				  byte[] decodedPdfBytes = Base64.getDecoder().decode(pdfParts[1]);
				  String pdfFilePath = folderpath + "\\" + System.currentTimeMillis() + ".pdf";
		          System.out.println("Storing PDF at: " + pdfFilePath);
		          try (FileOutputStream fos = new FileOutputStream(pdfFilePath)) {
		                fos.write(decodedPdfBytes);
		            }
		          prodentity64.setPdffilepath(pdfFilePath);
			 }
			 System.out.println();
		 }
		 
		 return prodrepofolder.save(prodentity64);
			 
}
	 
	 
	 
	 //trial
	 public List<productbuisnessdto> fetchProductWithImage(String productname) throws IOException {
		 System.out.println("Received product name in fetchProductWithImage: " + productname);
		    if (productname == null || productname.isEmpty()) {
		        throw new IllegalArgumentException("Product name must be provided.");
		    }
		    
		    List<prodentity_folders> allProducts = prodrepofolder.findAll();
		    System.out.println("🔍 Checking all products in DB...");
		    for (prodentity_folders product : allProducts) {
		        System.out.println("Product in DB: " + product.getProductname());
		    }

		    List<prodentity_folders> productEntities = prodrepofolder.findByProductnameIgnoreCase(productname);
		    System.out.println("Products found in DB: " + productEntities.size());
		    
		    // Extract mobile numbers from products
		    Set<String> mobileNumbers = productEntities.stream()
		            .map(prodentity_folders::getMobilenumber)
		            .collect(Collectors.toSet());

		    // Fetch business details for these mobile numbers
		    List<buisnessdetailsent> businessDetailsList = buisnessdetailrepo.findBymobilenumberIn(mobileNumbers);

		    // Map mobile numbers to business details
		    Map<String, buisnessdetailsent> businessDetailsMap = businessDetailsList.stream()
		            .collect(Collectors.toMap(buisnessdetailsent::getMobilenumber, bd -> bd));
		    
		    // Convert to Base64
		    List<productbuisnessdto> productDtos = new ArrayList<>();
		    for (prodentity_folders productEntity : productEntities) {
		    	productbuisnessdto productDto = new productbuisnessdto();
		        productDto.setProductname(productEntity.getProductname());
		        productDto.setPrice(productEntity.getPrice());
		        productDto.setProductdescription(productEntity.getProductdescription());
		        productDto.setMobilenumber(productEntity.getMobilenumber());
		        productDto.setYoutubelink(productEntity.getYoutubelink());
		        productDto.setShippingoption(productEntity.getShippingoption());
		        productDto.setTaxoption(productEntity.getTaxoption());

		        File imageFile = new File(productEntity.getFilepath());
		        if (imageFile.exists()) {
		            byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
		            String base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
		            productDto.setFile(base64Image);
		        }
		        buisnessdetailsent businessDetails = businessDetailsMap.get(productEntity.getMobilenumber());
		        if (businessDetails != null) {
		            productDto.setCompanydetails(businessDetails.getCompanydetails());
		            productDto.setEmailaddress(businessDetails.getEmailaddress());
		            productDto.setName(businessDetails.getName());
		            productDto.setCity(businessDetails.getCity());
		            productDto.setState(businessDetails.getState());
		            productDto.setPincode(businessDetails.getPincode());
		        } else {
		            // Set default values if no business details are found
		            productDto.setCompanydetails("N/A");
		            productDto.setEmailaddress("N/A");
		            productDto.setName("N/A");
		            productDto.setCity("N/A");
		            productDto.setState("N/A");
		            productDto.setPincode("N/A");
		        }

		        productDtos.add(productDto);
		    }
		       
		    

		    return productDtos;
		}
	 
	 
	 
//	 public List<product_base64> fetchProductWithImage(String productname) throws IOException {
//		 System.out.println("Received product name in fetchProductWithImage: " + productname);
//		    if (productname == null || productname.isEmpty()) {
//		        throw new IllegalArgumentException("Product name must be provided.");
//		    }
//		    
//		    List<prodentity_folders> allProducts = prodrepofolder.findAll();
//		    System.out.println("🔍 Checking all products in DB...");
//		    for (prodentity_folders product : allProducts) {
//		        System.out.println("Product in DB: " + product.getProductname());
//		    }
//
//		    List<prodentity_folders> productEntities = prodrepofolder.findByProductnameIgnoreCase(productname);
//		    System.out.println("Products found in DB: " + productEntities.size());
//		    // Convert to Base64
//		    List<product_base64> productDtos = new ArrayList<>();
//		    for (prodentity_folders productEntity : productEntities) {
//		        product_base64 productDto = new product_base64();
//		        productDto.setProductname(productEntity.getProductname());
//		        productDto.setPrice(productEntity.getPrice());
//		        productDto.setProductdescription(productEntity.getProductdescription());
//		        productDto.setMobilenumber(productEntity.getMobilenumber());
//		        productDto.setYoutubelink(productEntity.getYoutubelink());
//		        productDto.setShippingoption(productEntity.getShippingoption());
//		        productDto.setTaxoption(productEntity.getTaxoption());
//
//		        File imageFile = new File(productEntity.getFilepath());
//		        if (imageFile.exists()) {
//		            byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
//		            String base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
//		            productDto.setFile(base64Image);
//		        }
//
//		        productDtos.add(productDto);
//		    }
//
//		    return productDtos;
//		}
	 
//	 _________________________________________________________________________________________________________
	 
//	 public List<product_base64> fetchProductWithImage(String productname, String city) throws IOException {
//		    // Fetch products by product name and city
//		    List<prodentity_folders> productEntities;
//		    if (productname != null && !productname.isEmpty() && city != null && !city.isEmpty()) {
//		        productEntities = prodrepofolder.findByproductnameContainingIgnoreCaseAndProductdescriptionContainingIgnoreCase(productname, city);
//		        System.out.println(productname + city);
//		    } else if (productname != null && !productname.isEmpty()) {
//		    	System.out.println(productname);
//		        productEntities = prodrepofolder.findByProductnameContainingIgnoreCase(productname);
//		    }  else {
//		        throw new IllegalArgumentException("At least one of 'productName' or 'city' must be provided.");
//		    }
//		    // Check if no products are found
//		    if (productEntities.isEmpty()) {
//		        throw new RuntimeException("No products found with name: " + productname + " and city: " + city);
//		    }
//
//		    // Convert products to DTO with Base64 images
//		    List<product_base64> productDtos = new ArrayList<>();
//		    for (prodentity_folders productEntity : productEntities) {
//		        product_base64 productDto = new product_base64();
//		        productDto.setProductname(productEntity.getProductname());
//		        productDto.setPrice(productEntity.getPrice());
//		        productDto.setProductdescription(productEntity.getProductdescription());
//		        productDto.setMobilenumber(productEntity.getMobilenumber());
//		        productDto.setYoutubelink(productEntity.getYoutubelink());
//		        productDto.setShippingoption(productEntity.getShippingoption());
//		        productDto.setTaxoption(productEntity.getTaxoption());
//		        
////		        productDto.setPdfFilepath(productEntity.getFilepath());
//		        
//		        
//
//		        // Fetch the image file and convert it to Base64
//		        File imageFile = new File(productEntity.getFilepath());
//		        if (imageFile.exists()) {
//		            byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
//		            String base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
//		            productDto.setFile(base64Image);
//		        } else {
//		            throw new RuntimeException("Image file not found at path: " + productEntity.getFilepath());
//		        }
//
//		        
//		     // Convert PDF to Base64
//		       
//		        File pdffile = new File(productEntity.getPdffilepath());
//		        if (pdffile.exists()) {
//		        	byte[] pdfBytes = Files.readAllBytes(pdffile.toPath());
//		        	String base64Pdf = "data:application/pdf;base64," + Base64.getEncoder().encodeToString(pdfBytes);
//		        	productDto.setPdffile(base64Pdf);
//		        }
//		        else {
//		            throw new RuntimeException("PDF file not found at path: " + productEntity.getPdffilepath());
//		        }
//		        
//		        productDtos.add(productDto);
//		    }
//
//		    return productDtos;
//		}
//	 
	 
	 //trial
	 public List<productbuisnessdto> getRandomProducts(int limit) {
		 List<prodentity_folders> randomProducts = prodrepofolder.findRandomProducts(limit);

		    if (randomProducts == null || randomProducts.isEmpty()) {
		        throw new RuntimeException("No random products found.");
		    }
		    List<productbuisnessdto> productDtos = new ArrayList<>();
		    // Extract mobile numbers
		    Set<String> mobileNumbers = randomProducts.stream()
		            .map(prodentity_folders::getMobilenumber)
		            .collect(Collectors.toSet());
		    
		    // Fetch business details for these mobile numbers
		    List<buisnessdetailsent> businessDetailsList = buisnessdetailrepo.findBymobilenumberIn(mobileNumbers);
		    
		    // Map mobile number to business details
		    Map<String, buisnessdetailsent> businessDetailsMap = businessDetailsList.stream()
		            .collect(Collectors.toMap(buisnessdetailsent::getMobilenumber, bd -> bd));
		    
		    // Process products and add business details
		    for (prodentity_folders productEntity : randomProducts) {
		    	productbuisnessdto productDto = new productbuisnessdto();
		        productDto.setId(productEntity.getId());
		        productDto.setProductname(productEntity.getProductname());
		        productDto.setPrice(productEntity.getPrice());
		        productDto.setProductdescription(productEntity.getProductdescription());
		        productDto.setMobilenumber(productEntity.getMobilenumber());
		        productDto.setYoutubelink(productEntity.getYoutubelink());
		        productDto.setShippingoption(productEntity.getShippingoption());
		        productDto.setTaxoption(productEntity.getTaxoption());

		        // Convert image to Base64
		        String imagePath = productEntity.getFilepath();
		        if (imagePath != null && !imagePath.isEmpty()) {
		            File imageFile = new File(imagePath);
		            if (imageFile.exists()) {
		                try {
		                    byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
		                    String base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
		                    productDto.setFile(base64Image);
		                } catch (IOException e) {
		                    System.err.println("Error reading image file: " + imagePath);
		                    e.printStackTrace();
		                    productDto.setFile(null);
		                }
		            } else {
		                System.err.println("Image file not found at: " + imagePath);
		                productDto.setFile(null);
		            }
		        }
		       
		     // Get business details based on mobile number
		        buisnessdetailsent businessDetails = businessDetailsMap.get(productEntity.getMobilenumber());
		        if (businessDetails != null) {
		        	productDto.setCompanydetails(businessDetails.getCompanydetails());
		            productDto.setEmailaddress(businessDetails.getEmailaddress());
		            productDto.setName(businessDetails.getName());
		            productDto.setCity(businessDetails.getCity());
		            productDto.setState(businessDetails.getState());
		            productDto.setPincode(businessDetails.getPincode());
		        } else {
		        
		            productDto.setCompanydetails("N/A");
		            productDto.setEmailaddress("N/A");
		            productDto.setName("N/A");
		            productDto.setCity("N/A");
		            productDto.setState("N/A");
		            productDto.setPincode("N/A");
		        }

		        productDtos.add(productDto);
		    }

		    return productDtos;
	 }
	 
	 
//	 public List<product_base64> getRandomProducts(int limit) {
//		    List<prodentity_folders> randomProducts = prodrepofolder.findRandomProducts(limit);
//
//		    if (randomProducts == null || randomProducts.isEmpty()) {
//		        throw new RuntimeException("No random products found.");
//		    }
//
//		    List<product_base64> productDtos = new ArrayList<>();
//
//		    for (prodentity_folders productEntity : randomProducts) {
//		        product_base64 productDto = new product_base64();
//		        productDto.setId(productEntity.getId());
//		        productDto.setProductname(productEntity.getProductname());;
//		        productDto.setPrice(productEntity.getPrice());
//		        productDto.setProductdescription(productEntity.getProductdescription());
//		        productDto.setMobilenumber(productEntity.getMobilenumber());
//		        productDto.setYoutubelink(productEntity.getYoutubelink());
//		        productDto.setShippingoption(productEntity.getShippingoption());
//		        productDto.setTaxoption(productEntity.getTaxoption());
//		        
////		        productDto.setPdfFilepath(productEntity.getFilepath());
//		        
//
//		        // Convert the image to Base64 if it exists
//		        String imagePath = productEntity.getFilepath();
//		        if (imagePath != null && !imagePath.isEmpty()) {
//		            File imageFile = new File(imagePath);
//		            if (imageFile.exists()) {
//		                try {
//		                    byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
//		                    String base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
//		                    productDto.setFile(base64Image);
//		                } catch (IOException e) {
//		                    System.err.println("Error reading image file: " + imagePath);
//		                    e.printStackTrace();
//		                    productDto.setFile(null); // Set to null if there's an error
//		                }
//		            } else {
//		                System.err.println("Image file not found at: " + imagePath);
//		                productDto.setFile(null);
//		            }
//		        }
//		        
//		        // Convert the PDF to Base64 if it exists
//
//		        String pdfPath = productEntity.getPdffilepath();
//		        if(pdfPath != null && !pdfPath.isEmpty()) {
//		        	File pdffile = new File(pdfPath);
//		        	if(pdffile.exists()) {
//		        		try {
//		        	byte[] pdfBytes = Files.readAllBytes(pdffile.toPath());	
//		        	String base64Pdf = "data:application/pdf;base64," + Base64.getEncoder().encodeToString(pdfBytes);
//		        	productDto.setPdffile(base64Pdf);
//		        		}
//		        		catch(IOException e) {
//		        			  System.err.println("Error reading pdf file: " + pdfPath);
//			                    e.printStackTrace();
//			                    productDto.setPdffile(null); // Set to null if there's an error
//		        		}
//		        	}else {
//		                System.err.println("PDF file not found at: " + pdfPath);
//		                productDto.setPdffile(null);
//		            }
//		        	
//		        }
//		        
//		        
//		        
//		        
//
//		        productDtos.add(productDto);
//		    }
//
//		    return productDtos;
//		}
	 
	 //getting productsusing mobno for product page

	 public List<product_base64> getProductsByMobile(String mobilenumber) {
		 List<prodentity_folders> userProducts = prodrepofolder.findBymobilenumber(mobilenumber);
		 
		 if (userProducts == null || userProducts.isEmpty()) {
		        throw new RuntimeException("No products found for this mobile number.");
		    }
		  List<product_base64> productDtos = new ArrayList<>();
		  
		  for (prodentity_folders productEntity : userProducts) {
		        product_base64 productDto = new product_base64();
		        productDto.setId(productEntity.getId());
		        productDto.setProductname(productEntity.getProductname());;
		        productDto.setPrice(productEntity.getPrice());
		        productDto.setProductdescription(productEntity.getProductdescription());
		        productDto.setMobilenumber(productEntity.getMobilenumber());
		        productDto.setYoutubelink(productEntity.getYoutubelink());
		        productDto.setShippingoption(productEntity.getShippingoption());
		        productDto.setTaxoption(productEntity.getTaxoption());
		        
//		        productDto.setPdfFilepath(productEntity.getFilepath());
		        

		        // Convert the image to Base64 if it exists
		        String imagePath = productEntity.getFilepath();
		        if (imagePath != null && !imagePath.isEmpty()) {
		            File imageFile = new File(imagePath);
		            if (imageFile.exists()) {
		                try {
		                    byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
		                    String base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
		                    productDto.setFile(base64Image);
		                } catch (IOException e) {
		                    System.err.println("Error reading image file: " + imagePath);
		                    e.printStackTrace();
		                    productDto.setFile(null); // Set to null if there's an error
		                }
		            } else {
		                System.err.println("Image file not found at: " + imagePath);
		                productDto.setFile(null);
		            }
		        }
		        
		        // Convert the PDF to Base64 if it exists

		        String pdfPath = productEntity.getPdffilepath();
		        if(pdfPath != null && !pdfPath.isEmpty()) {
		        	File pdffile = new File(pdfPath);
		        	if(pdffile.exists()) {
		        		try {
		        	byte[] pdfBytes = Files.readAllBytes(pdffile.toPath());	
		        	String base64Pdf = "data:application/pdf;base64," + Base64.getEncoder().encodeToString(pdfBytes);
		        	productDto.setPdffile(base64Pdf);
		        		}
		        		catch(IOException e) {
		        			  System.err.println("Error reading pdf file: " + pdfPath);
			                    e.printStackTrace();
			                    productDto.setPdffile(null); // Set to null if there's an error
		        		}
		        	}else {
		                System.err.println("PDF file not found at: " + pdfPath);
		                productDto.setPdffile(null);
		            }
		        	
		        }
		        
		        
		        
		        

		        productDtos.add(productDto);
		    }

		    return productDtos;
		 
	 }
	 
	 //deleete product
	 
	 public boolean deleteProductById(int id) {
		    Optional<prodentity_folders> product = prodrepofolder.findById(id);
		    if (product.isPresent()) {
		        prodrepofolder.deleteById(id);
		        return true;
		    }
		    return false;
		}

}
