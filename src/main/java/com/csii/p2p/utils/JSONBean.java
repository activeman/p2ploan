package com.csii.p2p.utils;

/*
 这个类的作用是每次服务器端向客户端返回的数据jsonbean
 */
public class JSONBean {
	
	private String errno;   //错误码   0 表示没有错误    1表示有错误
	private String errmsg;	//错误信息   错误信息英文
	private String text;	//系统描述	中文描述
	private Object results;		//返回的真实数据
	
	
	public String getErrno() {
		return errno;
	}
	public void setErrno(String errno) {
		this.errno = errno;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Object getResults() {
		return results;
	}
	public void setResults(Object results) {
		this.results = results;
	}
	//正常返回
	public JSONBean(Object obj) {
		super();
		//this.errno = "0";
		this.errno = Err_no.error0000;
		this.text = "请求正常";
		this.results = obj;
	}
	//异常返回
	public JSONBean(String err_no,String text){
		this.errno = err_no;
		//this.errmsg = err_msg;
		this.text = text;
		this.results = null;
	}
	@Override
	public String toString() {
		return "JSONBean [errno=" + errno + ", errmsg=" + errmsg + ", text=" + text + ", results=" + results + "]";
	}
	
	
}


class Err_no{

	public static String error0000 = "0000";		//正常
	public static String error1000 = "1000";		//系统错误或无法获取的异常，默认错误
	public static String error2001 = "2001";		//缺少某个参数
	public static String error2002 = "2002";		//用户key错误
	public static String error2003 = "2003";		//timestamp超出请求预期
	public static String error2010 = "2010";		//签名校验失败
	public static String error2100 = "2100";		//需要用户登陆的地方为检测到合法的用户信息，需要跳转到登陆页面
	
	
}

