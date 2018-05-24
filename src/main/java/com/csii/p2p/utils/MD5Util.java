package com.csii.p2p.utils;

import java.math.BigInteger;  
import java.security.MessageDigest;  
  
public class MD5Util {  
      
     /** 
     * 对字符串md5加密(小写+字母) 
     * 
     * @param str 传入要加密的字符串 
     * @return  MD5加密后的字符串 
     */  
    public static String getMD5(String str) {  
        try {  
            // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            // 计算md5函数  
            md.update(str.getBytes());  
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符  
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值  
            return new BigInteger(1, md.digest()).toString(16);  
        } catch (Exception e) {  
           e.printStackTrace();  
           return null;  
        }  
    }  
      
      
    /** 
     * 对字符串md5加密(大写+数字) 
     * 
     * @param str 传入要加密的字符串 
     * @return  MD5加密后的字符串 
     */  
      
    public static String MD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
  
        try {  
            byte[] btInput = s.getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
     public static void main(String[] args) {  
        /*String md5 = MD5("password");  
        System.out.println( md5 );
        */
    	//String md52 = getMD5("发个非官方的过分的话更符合规范化更符合规范化更符合规范化更符合规范化更符合规范化国际化国际化挂号费广东省地方国际化贵航股份的速度规划和规划共和国和规范化国际化飞机和国际化过几天又投入股份的火锅店和规范和更好的伙食费更符合规划讲话稿发送给对方是规范的和规范化");    
        
    	String md52 = "{\"client_ip\":\"192.168.239.136\",\"client_key\":\"ggfhgfhgfhgjghgfdgfdgfdgf\",\"location\":\"116.40741300000002,39.904214\",\"sessionid\":\"dfdfdggfhgjkfggggdhhgjhjghgfjhgjhgghgfjgfjgf\",\"app_version\":\"Beta1.0\",\"os\":\"ios9\",\"timestamp\":\"376539658590869853465\",\"device_id\":\"GF&^&#DBEFGRJ(#JGHF67383JKSD\",\"pushtoken\":\"fgfhfggfgfdhgfhgfj46yr654wters45tret\",\"brand\":\"IPHONE6Plus\",\"screen\":\"1920*1080\"}";

    	 System.out.println( getMD5(md52) );      
    
     }  
}  