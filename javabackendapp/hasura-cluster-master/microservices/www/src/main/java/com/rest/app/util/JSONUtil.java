package com.rest.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
	
	public static String toJson(Object obj)
	{
	ObjectMapper mapper = new ObjectMapper();
	String jsonString = null;

	try
	{
	//Object to JSON in String
	jsonString = mapper.writeValueAsString(obj);
	}
	catch (JsonProcessingException e)
	{
	e.printStackTrace();
	}
	return jsonString;
	}

}
