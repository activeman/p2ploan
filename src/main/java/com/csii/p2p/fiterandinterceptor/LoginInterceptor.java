package com.csii.p2p.fiterandinterceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.plugin.InterceptorChain;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.csii.p2p.utils.HttpUtils;

/*
 这是一个判断用户是否登录的拦截器
 */
@Repository
public class LoginInterceptor extends  HandlerInterceptorAdapter{

	 private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	 /*
	  不进行拦截的url
	  */
	 private List<String> excludedUrls;
	 
	 public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	/** 
	  * 在业务处理器处理请求之前被调用 
	  * 如果返回false 
	  *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	  *     
	  * 如果返回true 
	  *    执行下一个拦截器,直到所有的拦截器都执行完毕 
	  *    再执行被拦截的Controller 
	  *    然后进入拦截器链, 
	  *    从最后一个拦截器往回执行所有的postHandle() 
	  *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
	  */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.preHandle(request, response, handler);
		
		String userAgent = request.getHeader("user-agent");
		System.out.println("userAgent:-- "+userAgent+" --");
		
		//如果是苹果设备
		if(userAgent.toLowerCase()!=null && userAgent.toLowerCase().contains("ios")){
			String iosmsg = HttpUtils.getMessageFromHttpServletRequest(request);
			String[] iosstrs = iosmsg.split("&");
			
			Map<String,Object>mp = new HashMap<String,Object>();
			for(String iosstr:iosstrs){
				mp.put(iosstr.split("=")[0], iosstr.split("=")[1]);
			}
			JSONObject jo = new JSONObject(mp);
			request.setAttribute("jsonmsg", jo.toString());
		}
		//如果是android设备
		else if(userAgent.toLowerCase()!=null && userAgent.toLowerCase().contains("android")){
			request.setAttribute("jsonmsg", HttpUtils.getMessageFromHttpServletRequest(request));
		}
		//如果是其他类型的设备
		else{
			request.setAttribute("jsonmsg", HttpUtils.getMessageFromHttpServletRequest(request));
		}
		
		
		
		String requesturi = request.getRequestURI().substring(8);
		System.out.println("请求路径---- " + requesturi );
		
		if(excludedUrls.contains(requesturi))
			return true;
		else{
			//判断是否登录
			
			
			return false;
		}
	}

	/**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作   
     * 可在modelAndView中加入数据，比如当前时间
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	
	/** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等    
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	 
	
}
