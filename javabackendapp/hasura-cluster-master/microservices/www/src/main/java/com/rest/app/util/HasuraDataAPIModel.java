package com.rest.app.util;

import java.util.HashMap;

public class HasuraDataAPIModel {
	
	private String type ;
	
	private HashMap<String, Object> args;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HashMap<String, Object> getArgs() {
		return args;
	}

	public void setArgs(HashMap<String, Object> args) {
		this.args = args;
	}
	
	
 
}
