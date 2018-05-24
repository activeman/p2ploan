package com.csii.p2p.utils;

/** 
 * @file RSATool.java 
 * @date 2016年8月5日 
 * @version 3.4.1 
 * 
 * Copyright (c) 2013 Sihua Tech, Inc. All Rights Reserved. 
 */  
   
/** 
 *  
 * 
 * @author chengjian.he 
 * @version  3.4, 2016年8月5日 上午10:51:35  
 * @since   Yeexun 3.4 
 */  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;  
import java.security.Key;  
import java.security.KeyPair;  
import java.security.KeyPairGenerator;  
import java.security.NoSuchAlgorithmException;  
import java.security.interfaces.RSAPrivateKey;  
import java.security.interfaces.RSAPublicKey;  
  
import javax.crypto.Cipher;  
import javax.crypto.NoSuchPaddingException;  
  

/*
 RSA非对称加密算法
 */
public class RSATool {  
  
    public static void makekeyfile(String pubkeyfile, String privatekeyfile)  
            throws NoSuchAlgorithmException, FileNotFoundException, IOException {  
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
        // 初始化密钥对生成器，密钥大小为1024位  
        keyPairGen.initialize(1024);  
        // 生成一个密钥对，保存在keyPair中  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
  
        // 得到私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
  
        // 得到公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
  
        // 生成私钥  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(  
                privatekeyfile));  
        oos.writeObject(privateKey);  
        oos.flush();  
        oos.close();  
  
        oos = new ObjectOutputStream(new FileOutputStream(pubkeyfile));  
        oos.writeObject(publicKey);  
        oos.flush();  
        oos.close();  
  
        System.out.println("make file ok!");  
    }  
  
    /** 
     *  
     * @param k 
     * @param data 
     * @param encrypt 
     *            1 加密 0解密 
     * @return 
     * @throws NoSuchPaddingException 
     * @throws Exception 
     */  
    public static byte[] handleData(Key k, byte[] data, int encrypt)  
            throws Exception {  
  
        if (k != null) {  
  
            Cipher cipher = Cipher.getInstance("RSA");  
  
            if (encrypt == 1) {  
                cipher.init(Cipher.ENCRYPT_MODE, k);  
                byte[] resultBytes = cipher.doFinal(data);  
                return resultBytes;  
            } else if (encrypt == 0) {  
                cipher.init(Cipher.DECRYPT_MODE, k);  
                byte[] resultBytes = cipher.doFinal(data);  
                return resultBytes;  
            } else {  
                System.out.println("参数必须为: 1 加密 0解密");  
            }  
        }  
        return null;  
    }  
  
    public static void main(String[] args) throws Exception {  
    	//公钥生成位置
        String pubfile = "F:/eclipse_workspace/p2ploan/src/main/resources/rsakeys/pub.key";  
        //私钥生成位置
        String prifile = "F:/eclipse_workspace/p2ploan/src/main/resources/rsakeys/pri.key";  
  
         makekeyfile(pubfile, prifile);  
  
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pubfile));  
        RSAPublicKey pubkey = (RSAPublicKey) ois.readObject();  
        ois.close();  
  
        ois = new ObjectInputStream(new FileInputStream(prifile));  
        RSAPrivateKey prikey = (RSAPrivateKey) ois.readObject();  
        ois.close();  
  
        // 使用公钥加密  
        String msg = "~O(∩_∩)O哈哈~";  
        String enc = "UTF-8";  
  
        // 使用公钥加密私钥解密  
        System.out.println("原文: " + msg);  
        byte[] result = handleData(pubkey, msg.getBytes(enc), 1);  
        System.out.println("加密: " + new String(result, enc));  
        byte[] deresult = handleData(prikey, result, 0);  
        System.out.println("解密: " + new String(deresult, enc));  
  
        msg = "嚯嚯";  
        // 使用私钥加密公钥解密  
        System.out.println("原文: " + msg);  
        byte[] result2 = handleData(prikey, msg.getBytes(enc), 1);  
        System.out.println("加密: " + new String(result2, enc));  
        byte[] deresult2 = handleData(pubkey, result2, 0);  
        System.out.println("解密: " + new String(deresult2, enc));  
  
    }  
}  