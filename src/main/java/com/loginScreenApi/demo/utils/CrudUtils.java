package com.loginScreenApi.demo.utils;

import java.util.List;

import com.loginScreenApi.demo.Exception.RessposseException;

public class CrudUtils {

	public static void addVerify(List<?> obj, String msg) throws RessposseException {
		
		if(obj.size() != 0) {
			
			throw new RessposseException(msg);
			
		}
		
	}
}
