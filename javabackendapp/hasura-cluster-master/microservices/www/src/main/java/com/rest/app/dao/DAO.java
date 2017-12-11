package com.rest.app.dao;

import java.util.HashMap;

import com.rest.app.util.DataAPIUtil;

public class DAO {
	
	public String getStores(String storeType) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("table", "stores");
		params.put("columns", new String[] {"*"});
		
		//System.out.println(selectDataFromTable(params));
		
		
		if(storeType!=null)
		{
			HashMap<String, String> whereCondition = new HashMap<String, String>();
			whereCondition.put("type", storeType);
			
			params.put("where", whereCondition);
			
		}
		
		String data = DataAPIUtil.selectDataFromTable(params);
		
		return data;
		
	}
	
	public String getproducts(String storeId) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("table", "products");
		params.put("columns", new String[] {"*"});
		
		HashMap<String, String> whereCondition = new HashMap<String, String>();
		whereCondition.put("store", storeId);
		
		params.put("where", whereCondition);
		
		String data = DataAPIUtil.selectDataFromTable(params);
		
		return data;
		
	}
	
	
	
	//test
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		String data = dao.getproducts("2");
		System.out.println(data);
		
	}

}
