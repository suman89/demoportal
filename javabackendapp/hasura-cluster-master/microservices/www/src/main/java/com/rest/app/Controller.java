package com.rest.app;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.app.dao.DAO;

@RestController
@RequestMapping("/")
public class Controller {
	
	@RequestMapping(path="/")
	public String hello() {
		return "Welcome" ; 
	}
	
	@RequestMapping(path="/stores", method= {RequestMethod.GET})
	public String getStores(@RequestParam(name="storeType", required=false) String storeType) {
		
		DAO dao = new DAO();
		
		return dao.getStores(storeType); 
	}
	
	@RequestMapping(path="/products", method= {RequestMethod.GET})
	public String getProducts(@RequestParam(name="storeId", required=true) String storeId) {
		
		DAO dao = new DAO();
		
		return dao.getproducts(storeId); 
	}
	
	
}
