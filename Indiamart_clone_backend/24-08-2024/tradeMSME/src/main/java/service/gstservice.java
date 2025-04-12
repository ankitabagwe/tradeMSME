package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import entity.gstpandetails;
import repository.gstrepo;

@Service
public class gstservice {

	@Autowired
	private gstrepo gstrepos;
	
	public gstpandetails SaveDetails(gstpandetails e) {
		return gstrepos.save(e);
	}
}
