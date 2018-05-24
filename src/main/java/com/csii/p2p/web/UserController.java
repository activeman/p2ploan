package com.csii.p2p.web;

import java.net.URLDecoder;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.csii.p2p.entity.User;
import com.csii.p2p.service.UserService;
import com.csii.p2p.utils.CustomConfig;
import com.csii.p2p.utils.HttpUtils;
import com.csii.p2p.utils.JSONBean;
import com.csii.p2p.utils.JsonUtils;
import com.csii.p2p.utils.RSAUtils;

@Controller
@RequestMapping(value="user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="userlist")
	@ResponseBody
	public JSONBean getUserList(){
		List<User> ulist = userService.getUserList();
		
		//JSONObject jo = JSONObject.
		
		//JSONObject jo = new JSONObject(ulist);
		
		JSONBean jb = new JSONBean(ulist);
		System.out.println(jb.toString());
		return jb;
	}
	
	
	
	/*
	 检测用户是否已经注册
	 */
	@RequestMapping(value="checkIfRegiste",method=RequestMethod.POST)
	@ResponseBody
	public JSONBean checkIfRegist(HttpServletRequest request,HttpServletResponse response){
		
		String jsonstr1 = HttpUtils.getMessageFromHttpServletRequest(request);
		
		Map<String,Object> mp = new HashMap<String,Object>();
		if(!"".equals(jsonstr1)){
			JSONObject jo = new JSONObject(new JSONObject(jsonstr1).get("otherdata").toString());
			String u_phone = jo.get("u_phone").toString();
			System.out.println(u_phone);
			boolean isregist = userService.checkIfRegist(u_phone);
			mp.put("isregist", isregist);	
		}
		
		return new JSONBean(mp);
	
	}
	
	
	
	/*
	 用户注册的方法
	 */
	@RequestMapping(value="userregist")
	@ResponseBody
	public JSONBean userregist(HttpServletRequest request,HttpServletResponse response){
		try{
			
			String jsonmsg = (String) request.getAttribute("jsonmsg");
			System.out.println(jsonmsg);
			
			//JSON json = JSON.to
			
			JSONObject jo = new JSONObject( jsonmsg );
			String signature = (String) jo.get("signature");
			
			//获取数字签名
			System.out.println("signature:  "+URLDecoder.decode(signature, "UTF-8"));
			//使用私钥对加密信息进行解码的操作
			byte[] b64s = Base64.getDecoder().decode(URLDecoder.decode(signature, "UTF-8"));
			byte[] bufs = RSAUtils.decryptByPrivateKey( b64s,  CustomConfig.getValue("privateKey"));
			System.out.println( new String(bufs) );
			
			//把传过来的值存入到数据库当中
			User user = JSON.parseObject( jsonmsg, User.class);
			user.setCreatedate(new Date());
			user.setUpdatedate(new Date());
			int result = userService.addUser(user);
			
			//向客户端返回状态
			Map<String,Object>mp = new HashMap<String,Object>();
			if(result>0){
				mp.put("registsuccess", true);
				return new JSONBean( mp );
			}else{
				mp.put("registsuccess", false);
				return new JSONBean( mp );
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//System.out.println(  CustomConfig.getValue("privateKey") );
		//RSAUtils.decryptByPrivateKey(encryptedData, privateKey)
		
		
		/*
		System.out.println(jsonstr);
		*/
	
		
		
	}
	
	
}
