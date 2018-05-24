package com.csii.p2p.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.csii.p2p.entity.User;

import sun.misc.BASE64Decoder;

public class RSATester2 {

	public static void main(String[] args) throws Exception {
		
		String str = "nsiaivisdcsjkcjbjbJHBHSVBJSDBJVBJBjbjbcvbdvjkj%7B%7Dhudgyufdsu";
		
		String str1 = "nsiaivisdcsjkcjbjbJHBHSVBJSDBJVBJBjbjbcvbdvjkj{}hudgyufdsu";
		
		String newstr = new String(str.getBytes("iso-8859-1"),"UTF-8");
		
		String result = URLDecoder.decode(str, "UTF-8");
		
		System.out.println(result);
		
		String encodestr = URLEncoder.encode(str1, "UTF-8");
		System.out.println(encodestr);
		
	}
	
	
	public  static  void main5(String[] args) {
		/*
		String str = "app_version=Beta1.0&brand=IPHONE6Plus&client_ip=192.168.239.136&client_key=ggfhgfhgfhgjghgfdgfdgfdgf&device_id=wedsdfggsxa&invitePhone=15221514992&location=116.40741300000002%2C39.904214&os=ios9&pushtoken=bhsbusucubsjhc&screen=1920%2A1080&sessionid=dfdfdggfhgjkfggggdhhgjhjghgfjhgjhgghgfjgfjgf&sms_checkcode=1234&timestamp=376539658590869853465&uPassword=12345678&uPhone=15221514992";
	
		JSONObject jo = new JSONObject();
		
		System.out.println( jo.toString() );
		*/
		/*
		String iosmsg = "app_version=Beta1.0&brand=IPHONE6Plus&client_ip=192.168.239.136&client_key=ggfhgfhgfhgjghgfdgfdgfdgf&device_id=wedsdfggsxa&invitePhone=15221514992&location=116.40741300000002%2C39.904214&os=ios9&pushtoken=bhsbusucubsjhc&screen=1920%2A1080&sessionid=dfdfdggfhgjkfggggdhhgjhjghgfjhgjhgghgfjgfjgf&sms_checkcode=1234&timestamp=376539658590869853465&uPassword=12345678&uPhone=15221514992";
		String[] iosstrs = iosmsg.split("&");
		
		String str = "app_version=Beta1.0&brand=IPHONE6Plus&client_ip=192.168.239.136&client_key=ggfhgfhgfhgjghgfdgfdgfdgf&device_id=wedsdfggsxa&invitePhone=15221514992&location=116.40741300000002%2C39.904214&os=ios9&pushtoken=bhsbusucubsjhc&screen=1920%2A1080&sessionid=dfdfdggfhgjkfggggdhhgjhjghgfjhgjhgghgfjgfjgf&sms_checkcode=1234&timestamp=376539658590869853465&uPassword=12345678&uPhone=15221514992";
		
		Map<String,Object>mp = new HashMap<String,Object>();
		for(String iosstr:iosstrs){
			mp.put(iosstr.split("=")[0], iosstr.split("=")[1]);
		}
		JSONObject jo = new JSONObject(mp);
		System.out.println( jo.toString() );
		*/
		
		
		//String jsonstr = "{\"client_ip\":\"192.168.239.136\",\"client_key\":\"ggfhgfhgfhgjghgfdgfdgfdgf\",\"location\":\"116.40741300000002,39.904214\",\"sessionid\":\"dfdfdggfhgjkfggggdhhgjhjghgfjhgjhgghgfjgfjgf\",\"app_version\":\"Beta1.0\",\"os\":\"ios9\",\"timestamp\":\"376539658590869853465\",\"device_id\":\"GF&^&#DBEFGRJ(#JGHF67383JKSD\",\"pushtoken\":\"fgfhfggfgfdhgfhgfj46yr654wters45tret\",\"brand\":\"IPHONE6Plus\",\"screen\":\"1920*1080\",\"signature\":\"ffgfhgghghghgjghhfddshjhhj\",\"uphone\":\"13096789876\",\"sms_checkcode\":\"1234\",\"upassword\":\"13096789876\",\"invitePhone\":\"17625485623\"}";
		
		String jsonstr = "{\"clientip\":\"192.168.239.136\",\"clientkey\":\"ggfhgfhgfhgjghgfdgfdgfdgf\",\"location\":\"116.40741300000002,39.904214\",\"sessionid\":\"dfdfdggfhgjkfggggdhhgjhjghgfjhgjhgghgfjgfjgf\",\"appversion\":\"Beta1.0\",\"os\":\"ios9\",\"timestamp\":\"376539658590869853465\",\"deviceid\":\"GF&^&#DBEFGRJ(#JGHF67383JKSD\",\"pushtoken\":\"fgfhfggfgfdhgfhgfj46yr654wters45tret\",\"brand\":\"IPHONE6Plus\",\"screen\":\"1920*1080\",\"signature\":\"ffgfhgghghghgjghhfddshjhhj\",\"uphone\":\"13096789876\",\"smscheckcode\":\"1234\",\"upassword\":\"13096789876\",\"invitephone\":\"17625485623\"}";
		
		//JSONObject json = JSON.parseObject(jsonstr);
		
		User user = JSON.parseObject(jsonstr, User.class);
		System.out.println( user.getDeviceid() );
		System.out.println( user.getUphone() );
		System.out.println( user.getUpassword() );
		System.out.println( user.getInvitephone() );
		
	/*
		MyUser user = JSON.parseObject(jsonstr, MyUser.class);
		System.out.println(user.getUphone());
		System.out.println(user.getUpassword());
		System.out.println(user.getInvitePhone());*/
	}
	
	
	public static void main4(String[] args) throws Exception {
		
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDRoWRHzd7n5e2yFl5vdKfA5W8FG0LfZgRAtUk9BIyt/1yQfxj+aGP3DJZO2mZsXpNbVjSjNoh2nUNcEeZYqoavrYadr1gTpNU7jj1eXyNhi1uQvlrrjjeS8KGANu0IrmuskKeZ+qOttkKrN532vbqshhZBb0g+ptSOQVWP7oyTnQIDAQAB";
		
		byte[] bufs = RSAUtils.encryptByPublicKey("测试公钥加密和私钥解密".getBytes(), publicKey);
		byte[] b64s  = Base64.getEncoder().encode(bufs);
		//System.out.println(new String(bufs));
		System.out.println(new String( b64s ));
		
	}
	
	
	public static void main3(String[] args) {
		
		//byte[] results = RSAUtils.decryptByPublicKey(bufs, publickey);
		try {
			
			long starttime = System.currentTimeMillis();
			
			System.out.println("------------测试公钥加密私钥解密-----------");
			
			Map<String,Object>map = RSAUtils.genKeyPair();
			/*
			String privatekey = RSAUtils.getPrivateKey(map);
			String publickey = RSAUtils.getPublicKey(map);
			*/
			
			String publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWD7kp/b/2tc+/E5AZVntCPNkJkiS6GehhJH5ayWUVNqwUKDXWTnqFbX63p2uxDrJXTk1A2j23xEeV3iRlGjhb92GjGprIhzdzsoxR+bGUW6HtMqsuvVe08g0JmbZSflIZ0Mh/h+myRnuKRSRYMj6nd20gf51X6xEEf/uGPMM81wIDAQAB";
			String privatekey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJYPuSn9v/a1z78TkBlWe0I82QmSJLoZ6GEkflrJZRU2rBQoNdZOeoVtfrena7EOsldOTUDaPbfER5XeJGUaOFv3YaMamsiHN3OyjFH5sZRboe0yqy69V7TyDQmZtlJ+UhnQyH+H6bJGe4pFJFgyPqd3bSB/nVfrEQR/+4Y8wzzXAgMBAAECgYEAhayD+Y/9TLwwz7mRh8CuFBc4D3qMFOu3QbHMjPsSfI8zQtF/A+Ts56beVqNhH1xEKdmqn7bJe8XxLuOv8BAnWwgA4DbqXWaebKULn6rbq0zglrQ6QjgOHBCu4pbXAGDnsbsdnJT0YIPiAj4j4lUA8bFCWMHE4q9e+8qp9qRdV2ECQQDIQHZjCBSEuhhlLOg8RSEhT9r5ZVQUDXfguU+tXnXJmW/5CRWct1A5bf5yw2tZpE+1ykOfvnBAWnbak548XAG1AkEAv9ZLXF62ZBEedRmm/0XMqcWX13/QX1+5jmBJzGC9rXoV91KzWTj9PvqcZYyvoHEy9v5TjSTIiCJKCevflu8L2wJAH29/Jiyui+dqzPcvvcZcXQ5cIap2eG9k0jJE/8JEW1Fq8n0ql19viJRrzThAMeJJYRBPbVRH6tJItidWP8NxwQJBAIB/D/eNUWpxtQ8G4b83h8FoIy8r4+0ed3IQuR325tZeYnxJnuxyqd8Xis7Sj4lOia676EcwjknxfdprblbxQ+UCQQC3vzZJVYgORw0ByAmC1pyXcCOMzsEMWb+zbxmHqQjng/57AVXUII6VU8JXxrUD57BwEzgyJKvk4G2VXKAzTce6";
			
			System.out.println("-----privatekey-----");
			System.out.println( privatekey );
			
			System.out.println("-----publickey-----");
			System.out.println( publickey );
			
			String datarequiredtodo = "{\"client_ip\":\"192.168.239.136\",\"client_key\":\"ggfhgfhgfhgjghgfdgfdgfdgf\",\"location\":\"116.40741300000002,39.904214\",\"sessionid\":\"dfdfdggfhgjkfggggdhhgjhjghgfjhgjhgghgfjgfjgf\",\"app_version\":\"Beta1.0\",\"os\":\"ios9\",\"timestamp\":\"376539658590869853465\",\"device_id\":\"GF&^&#DBEFGRJ(#JGHF67383JKSD\",\"pushtoken\":\"fgfhfggfgfdhgfhgfj46yr654wters45tret\",\"brand\":\"IPHONE6Plus\",\"screen\":\"1920*1080\"}";
			
			//byte[] bufs = RSAUtils.encryptByPublicKey(datarequiredtodo.getBytes(), publickey);
			//byte[]bufs = Base64.getDecoder().decode("I0qgnAEUWAKXfnKxZEjIxwRga85K/B95zc372PSu3p3USBGQJCwJOLgz%2BJ/pwGCXXusesH99jvPhfAk%2BZVkm948ukTzSclLP44cw51wB%2BVJI9Bs1RUvHWD5Adzx2ECVWAjgYboAPgy2LM2F5a45SO3VPxNmVtiN564y5yu7Np2SNK%2BXEfQH0loHyeriS5ox2HeK/LsjvGU9SElpLg0lIvJ/SmGMHnFuUFQwdBCFCdB20SqZRQLre%2BpAA0KssiaJx%2BPojWwdrDmTRzthY/RUOe1q9p%2BrQAra0pk9m0x0sOU5zveEYrkanagF9Cxh6AZlvUFGpnP5BqSeoeDY0fVPqhHooIbQhjSZwPwLwzRR0DK5ruoIgKEn0w6p2DTVNiHZOYV0lmRO0cCP4%2BtUccYZ/givPCtx%2BIu3TQ6O6HIO9jmjF7WK5SmtryLv52cswY/ERUdxgf15b2bhfkwt8OM09Ax0lVB0qcPITACYmAfJcgGcj%2BZhjb9hDKilqv8oZYb7i");
			
			//byte[]bufs = Base64.getDecoder().decode("QKnbzp4+RN36Fmlsm786+KhGHkLZbqvSZS5bv6e5iZEO1L+a5sizWnPpbAkePGG0FcjdA2j9Rfs1cGT5U6V9WMBChZGPq1mAiWp2Kt6iv4VDyyjCM4N7m84mgg/BeFeNB5Es/VI8ML8wZUlsL0JSEnpPHHCSC8E4sWKGxhsbm2tIUIB3d1AQyV4yQ/aA/ipfVK64QVBdiCbsipMA0fgG/hH3H3056VtE/atCi/fbimLsCNaxk8ZnTQiKcHIykJLUlR0UVa2crZcf3X1yqP5mxhvgge1xPxRJAZkcLrmSPU92ugj/90sOXgzzdkw95k9hY7uE1SzCMC9CfeFkYIt+gUhC7Q9MHSvGqmnu3NhyhlivJBFyjWP5LE/KObmUSOuKGZ3LvrLnDtZaL4TA4cMdAM/AxA2MtR54NK8KbHfHh9zeK3eXv8Dxmz7GFDRCB3ck2CgIfEJyUKQWQpE6aoEI9D6tli3SQ9vdTigvm6+NXQa8C4AeM1XrNrthVQmUWlz8");
			
			byte[]bufs = Base64.getDecoder().decode("YUZyeP0HzuzMZXylevEKKyt08bEUinLhZUOiKAckArLxVQSLmOQm3ub%2BRDCLEVcrw2l35yL8ajp8ZdOfleAZZuV8UKOYUt3CDhiU7Jp%2BaqGylg23gyG37/MVLAF7eBaPovauNPLiYubHGDogMnOFfoQYKFTQ891OKH0wiCSKNuQhh7%2Br9V2KZ77cJykACycKXaPr28qYE2TSzELGbeZ7SDFDTZwrOlXtjMkkDhJZdg1siExdwdnwOxyTV5KrApwgY1UGJC6Luj/kGSAPAAdFbHbRQWEn5ZLOGL6zppRpZPNRQ/bQA8ByuvsJ91CcBeMKUZ44i9K2tYad5S5ZQCZ6tRhehikzr9HH44CSmOD/sJlYlBs4HYf8hAuPXxMEBxraOvKq48pf%2BAPE0ZkkE22f4cm9exHrhcr7FfZZU00g7p126EF%2Bl0qFSyswxtHaMabNyoriY9gO8Au1k3H33nyLN4g6MjqztklYDqG5G3BV9LadV/QcDZmNhZWJX0P/icgo");
			
			byte[] result = RSAUtils.decryptByPrivateKey(bufs, privatekey);
			System.out.println(new String(result));
			
			long endtime = System.currentTimeMillis();
			
			System.out.println(endtime-starttime);
			
			//byte[] bufs = RSAUtils.decryptByPrivateKey("gCIhJsPC8l51jodUoQ9yf7GlfjXMtfGE95KyUoCtmTdqvdwxldfOxLx+t/VZl3pp2BKQvjBJ4eVtf34ebKQR7ZVReNfN29sdP4gxPwidoqO67wwBPwWmFk/G37h4OLqTEOmYdwWNjzCqhrZMwcfbXXNcjDx6DFtZpGaJYwFzuzI=".getBytes(), "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ7l+QSrba5pisXOSs07UOqE8amp0dSnA9mC6nQZWRGp/jzK7CxzbGLFIiXtUxtsEh5MMg8udkce7IHHtuBvlPssAbYYnPV+RG4iZOd9WX+28k0IMW+WbcOz7aMBe/GB6NIHbW++jaELNAS2tkM8kZbnyP6AnQVH9HTegxpFCaDTAgMBAAECgYBIGp1cVBoqWfRB/HGPHcqDER7EWa5A7CTgD/sqAdKcJGKc3Yw8Q4g8ba4oPcBHoku6eeMBZpj/fvXdkm3W/GtCsdl2GiSDEu/fePS94qOSVY/PD0hG8wShx/o203NrVZ6/F+ojvcSE66g/z921raUd/tn9ZUr65kQHiU4XQtQLGQJBAOmTElWl/FAFc9N+k7LWzoQzQWfNlj0TKJtnJ3hp67bTC1RAc4KJiuW5++OEDmsTWyyXBdl26SU2UNJv3VzVs88CQQCuJ3ehcGP4bYcLqLYEJ+bGUNrTYdvIWhu5J6OKbarqeoMYBOHtsjL7gGRUVQw4CTmNugfg4Yj+Qv5Fel5BiU+9AkA0AKGBXh4ptr0N5k198KMz/bFfKf98A4rz5mh8P6DSKHSKQns1IehBs0GoattG7Z1L9SfBPd80gL5Hy84OACozAkANcjamXEsbrzkyCUCkaYBD55I9p9yUR4DEdu8FjRoZKIReomHfPFb7XBpi+H4NBYlQDAD3t/Ifz4RaUOxeGv/xAkB7WP0517WF8jotYrWGucnurxWn2aGg5+4NRQo1N42Hv2x06A8cBG+sJM0II6BfIXIOLjoKaEKrNmSGpHyvtewH");
			
			
			/*
			String privatekey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJ+DlgECRoSp1xJMB4fKGA7p24rDiAV/J3dJPbaLRGaxdvth3bTLKRrhuM9AlYTsSRm/JwsGnYIdq0iDnyHB4rE/UqsUfzIf0/gCbwbEimUzu58mqjw7oiyPiOhYdevQSzAeexq6KpkdYFrs1Lsyn65F8rGcnoFxNXyP4Y6kXQEHAgMBAAECgYEAnZV5U3XUBKtk9YZ2ygc0zUbqxKN2dTew3X9VoEjlQi5/xMhiJoGuEgh8cwLys2ZasTzObW4TnL+CvxiI1Oid8bpF1rLHTnAxZSn7GYfifiQd5QWqBzBdR/MCa45gcijcdEUK6LpPiX75jJsj32XK5V4MoXtPtjZx4Z1/GXgv5EECQQDmjgZ5pte6rN6iKqC7mBEGVhlBxewe5QRRoYRecokVufG/Jo5djtefERAv2UF+5P5m6KMzCu+4nSrmkxjgkRm7AkEAsR5pWuyXy5w+b4tmLmo5Eu+gAh+y/DwgvmqbXJBGEJS8Cp9N3gvwwgW7lWiQqRd7zQBAjL8vIWyKKLftFafLJQJAMlEmyqAGDwCxahUBlU9/z7E0u+0VNjznL2WfvPkkP/Cf+QbSJUsKdfXEYZz5tVcGyrDVBUvKu7DZbw8Fa+VfBwJBAJJlWZ2OuvTPgwe9h8rLf7s4FuBKhS1ZIZNiGGIM2eywkzCQddMXuXsVM/QNhqxMvcY29COhjnoo9ZUsWSkyFIUCQQDj/gLWfbZMALJeU/1hTYEBPdLqSG4Jo8v9eTItYTeWjjtW1MmXOl6QV30nZVxLSmsjFUfTF3g5deB2NEWvKUR2";
			byte[] b64s = Base64.getDecoder().decode("AjyCGBDrFu7eqsMcCznV+mxI/I3byTTXi36cgK9U3C/V4aRiCoQAEXS5H8ijApmG0WYYl3iudBAnFt2jHUKqy0lxBxvew3gJpaR+BeGF80ZicW27eUqOnrGkax2p08w3I91j5ID7OlPJ8MuLHftEIUeDiZY8jgoX+lv7wCi9X3c=");
			byte[] bufs = RSAUtils.decryptByPrivateKey( b64s,  privatekey);
			System.out.println( new String(bufs) );
			*/
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main2(String[] args) {
		
		try {
			Map<String,Object>map = RSAUtils.genKeyPair();
		
			String privatekey = RSAUtils.getPrivateKey(map);
			String publickey = RSAUtils.getPublicKey(map);
			
			System.out.println("-----privatekey-----");
			System.out.println( privatekey );
			
			System.out.println("-----publickey-----");
			System.out.println( publickey );
			
			
			byte[] bufs = RSAUtils.encryptByPrivateKey("您好".getBytes(), privatekey);
			
			byte[] results = RSAUtils.decryptByPublicKey(bufs, publickey);
			
			System.out.println( new String(results) );
		
			
			byte[]encodedata = "sss".getBytes();
			
			RSAUtils.sign(encodedata, privatekey);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
