package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.buisnessdetailsent;
import entity.prodentity_folders;
import entity.product_base64;

@Repository
public interface prodrepo_folder extends JpaRepository<prodentity_folders, Integer>{
	
	 // Fetch by Product Name Only
//    List<prodentity_folders> findByProductnameContainingIgnoreCase(String productname);

	List<prodentity_folders> findByProductnameIgnoreCase(String productname);
  

    // Fetch by Mobile Number
    List<prodentity_folders> findByMobilenumber(String mobilenumber);
	
    List<prodentity_folders> findBymobilenumber(String mobilenumber);
	
    
    
	
	 
//	  
//	    List<prodentity_folders> findByProductnameContainingIgnoreCase(String productname);
//
////	  @Query("SELECT p FROM prodentity_folders p WHERE p.productName LIKE %:name%")
////	    List<prodentity_folders> findByProductName(@Param("name") String name);
//	    
//	    List<prodentity_folders> findByproductnameContainingIgnoreCaseAndProductdescriptionContainingIgnoreCase(String productname, String city);

	    List<prodentity_folders> findByProductdescriptionContainingIgnoreCase(String city);

	    @Query(value = "SELECT * FROM prodentity_folders ORDER BY RAND() LIMIT :limit", nativeQuery = true)
	    List<prodentity_folders> findRandomProducts(@Param("limit") int limit);
	    
	  
}
