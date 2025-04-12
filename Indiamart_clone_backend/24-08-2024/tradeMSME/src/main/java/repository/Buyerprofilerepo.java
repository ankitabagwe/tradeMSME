package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.buyerprofilee;

@Repository
public interface Buyerprofilerepo extends JpaRepository<buyerprofilee, String> {
//	  Optional<buyerprofilee> findBymobilenumber(String mobilenumber);
	buyerprofilee findBymobilenumber(String mobileNumber);

}
