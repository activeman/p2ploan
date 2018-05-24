package com.csii.p2p.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {

	
	/**
	 * 将对象转换为json格式字符串
	 * 
	 * @param Object
	 * @return json string
	 */
	public static String toJSON(Object obj) {
	    ObjectMapper om = new ObjectMapper();
	    try {
	        String json = om.writeValueAsString(obj);
	        return json;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	/**
	 * 
	 * 将json形式字符串转换为java实体类
	 * 
	 */
	public static <T> T parse(String jsonStr, Class<T> clazz) {
	    ObjectMapper om = new ObjectMapper();
	    T readValue = null;
	    try {
	        readValue = om.readValue(jsonStr, clazz);
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return readValue;
	}
	
}
