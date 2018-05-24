package com.csii.p2p.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

	
	/*
	public static boolean CheckAgent()    
	{    
		boolean flag = false;    
	  
	    String agent = HttpContext.Current.Request.UserAgent;    
	    string[] keywords = { "Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser" };    
	  
	       //排除 Windows 桌面系统    
	        if (!agent.Contains("Windows NT") || (agent.Contains("Windows NT") && agent.Contains("compatible; MSIE 9.0;")))    
	        {    
	            //排除 苹果桌面系统    
	            if (!agent.Contains("Windows NT") && !agent.Contains("Macintosh"))    
	            {    
	                foreach (string item in keywords)    
	                {    
	                    if (agent.Contains(item))    
	                    {    
	                        flag = true;    
	                        break;    
	                    }    
	                }    
	            }    
	        }    
	  
	    return flag;    
	}
	*/
	
	/*
	 通过request请求当中获取到客户端传送过来的   字符串
	 */
	public static String getMessageFromHttpServletRequest( HttpServletRequest request ){
	
		
		StringBuffer jsonStr = new StringBuffer();
		try {
			InputStream in = request.getInputStream();
			BufferedReader br = new BufferedReader( new InputStreamReader(in) );
			int len = 0;
			byte[]bufs = new byte[1024];
			while( (len = in.read(bufs) )!=-1 ){
				jsonStr.append( new String(bufs,0,len) );
			}
			System.out.println(jsonStr.toString());
			return jsonStr.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
		
		
	}
	
}
