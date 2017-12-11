package com.rest.app.util;

import java.util.HashMap;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;



public class DataAPIUtil {
	
	public static void main(String[] args) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("table", "users");
		params.put("columns", new String[] {"*"});
		
		System.out.println(selectDataFromTable(params));
		
		//Input data : {"type":"select","args":{"columns":["*"],"table":"users"}}
		
		/*Output :
		 * 
		 * [{"address":"Kolkata","name":"Suman","id":1,"type":"store_owner"}, 
		 {"address":"Kolkata","name":"Sukriti","id":2,"type":"store_owner"}, 
		 {"address":"Kolkata","name":"Falguni","id":3,"type":"store_owner"}, 
		 {"address":"Kolkata","name":"Admin","id":4,"type":"admin"}]*/
		
	}
	
	public static String selectDataFromTable(HashMap<String, Object> params) {
		
		String url = "https://data.cereal20.hasura-app.io/v1/query";
		String token = "Bearer c5bcb74a34cff7032a4519474b8ce5fb43061515c0db0925";
		
		String result = "" ; 

		try 
		{
			
			MediaType mediaType = MediaType.parse("application/json");
			
			HasuraDataAPIModel hasuraData = new HasuraDataAPIModel();
			hasuraData.setType("select");
			
			hasuraData.setArgs(params);
			
			//System.out.println(JSONUtil.toJson(hasuraData));

			RequestBody body = RequestBody.create(mediaType, JSONUtil.toJson(hasuraData));
			
			Request request = new Request.Builder()
				.url(url)
				.post(body)
				.addHeader("Authorization", token)
				.addHeader("content-type", "application/json")
				.build();

			
			OkHttpClient client = new OkHttpClient();
			
			Response res = client.newCall(request).execute();
			
			//System.out.println(res.body().string());
			
			result =  res.body().string();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	/*
	 * 
	 * Using rest template:
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	headers.add("content-type", "application/json");
	headers.add("Authorization", "Bearer c5bcb74a34cff7032a4519474b8ce5fb43061515c0db0925");

	HasuraDataAPIModel hasuraData = new HasuraDataAPIModel();
	hasuraData.setType("select");
	
	HashMap<String, String> params = new HashMap<String, String>();
	params.put("table", "users");
	params.put("columns", "*");
	
	hasuraData.setArgs(params);
	
	
	RestTemplate restTemplate = new RestTemplate();
	HttpEntity<HasuraDataAPIModel> request = new HttpEntity<HasuraDataAPIModel>(hasuraData, headers);
	
	
	ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);*/
	
	
	//System.out.println(response);

}
