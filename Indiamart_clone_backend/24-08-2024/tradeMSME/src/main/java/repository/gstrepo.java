package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.gstpandetails;

@Repository
public interface gstrepo extends JpaRepository<gstpandetails, Integer>{

}
