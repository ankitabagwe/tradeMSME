package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.buissnessdetailsadditional;

@Repository
public interface buissnessdetailsadditionalrepo extends JpaRepository<buissnessdetailsadditional, String> {
	buissnessdetailsadditional findBymobilenumber(String mobilenumber);
	
	 
}
