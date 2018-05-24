package com.csii.p2p.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csii.p2p.utils.JSONBean;

/*
 中央的一个控制器处理，处理业务逻辑
 */
@Controller
@RequestMapping(value="center")
public class CenterController {

	//获取到短信验证码
	@RequestMapping(value="getCheckCode")
	public JSONBean getCheckCode(HttpServletRequest request,HttpServletResponse response){
		
		//里面包含发短信的业务逻辑
		
		String msgcode = "1234";
		
		JSONBean jb = new JSONBean(msgcode);
		
		System.out.println(jb.toString());
		
		return jb;
		
	}
	
}
