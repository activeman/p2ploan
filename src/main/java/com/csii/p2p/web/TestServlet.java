package com.csii.p2p.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//super.doGet(req, resp);
		
		StringBuffer sb = new StringBuffer();
		
		InputStream in = req.getInputStream();
		BufferedReader br = new BufferedReader( new InputStreamReader(in) );
		int len = 0;
		byte[]bufs = new byte[1024];
		while( (len = in.read(bufs) )!=-1 ){
			sb.append( new String(bufs,0,len) );
		}
		System.out.println(sb.toString());
		//return jsonStr.toString();
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		super.doPost(req, resp);
		
		doGet( req,resp );
		
	}

	
	
}
