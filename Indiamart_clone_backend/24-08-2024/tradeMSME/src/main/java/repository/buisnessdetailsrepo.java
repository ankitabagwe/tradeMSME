package repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import entity.buisnessdetailsent;

@Repository
public interface buisnessdetailsrepo extends JpaRepository<buisnessdetailsent, String>{

	 boolean existsBymobilenumber(String mobilenumber);
	
//	 buisnessdetailsent findBymobilenumber(String mobilenumber);
	 
	  Optional<buisnessdetailsent> findBymobilenumber(String mobilenumber);
	  
	  @Query("SELECT b FROM buisnessdetailsent b WHERE b.mobilenumber IN :mobileNumbers")
	  List<buisnessdetailsent> findBymobilenumberIn(@Param("mobileNumbers") Set<String> mobileNumbers);
	 
//	  @Query("SELECT b.mobilenumber FROM buisnessdetails b WHERE LOWER(b.city) LIKE LOWER(CONCAT('%', :city, '%'))")
//	    List<String> findByCity(String city);
}
