package com.example.myFirstProject;  

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理 对原始数据进行AES加密后，在进行Base64编码转化�?
 */

public class AESOperator {
	/*
	 * 加密用的Key 可以�?26个字母和数字组成 此处使用AES-128-CBC加密模式，key�?要为16位�??
	 */
	//private String sKey = "1234567890123456";
	private byte[] ivParameter = new byte[16];
	private static AESOperator instance = null;

	private AESOperator() {

	}

	public static AESOperator getInstance() {
		if (instance == null)
			instance = new AESOperator();
		return instance;
	}

	/**AES/CBC/PKCS5Padding加密并base64转码
	 * 
	 * @param sSrc 内容
	 * @param sKey 秘钥
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String sSrc,String sKey) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] raw = sKey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			IvParameterSpec iv = new IvParameterSpec(ivParameter);// 使用CBC模式，需要一个向量iv，可增加加密算法的强�?
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码�??
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * AES/CBC/PKCS5Padding解密并base64并解
	 * @param sSrc 内容
	 * @param sKey 秘钥
	 * @return
	 * @throws Exception
	 */
	
	public String decrypt(String sSrc,String sKey){
		try {
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivParameter);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			ex.getMessage();
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			String str = "{data:[{'name':'asd','age':20},{'name':'zd','age':18}]}";
			String DeString1 = AESOperator.getInstance().decrypt(str,"zyhkgds987456123");
			System.out.println("加密后的字串是：" + DeString1);	
			
			String DeString = AESOperator.getInstance().decrypt(DeString1,"zyhkgds987456123");
			System.out.println("解密后的字串是：" + DeString);																																								
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

