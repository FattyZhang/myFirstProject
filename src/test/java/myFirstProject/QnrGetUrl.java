package myFirstProject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class QnrGetUrl {
	
	@Test
	public void test() {
		int sign = 2;// 1:全量 2:支付完成
		String TAG = "";
		String URL = "http://qae.qunar.com/api/router";
		String token = "78a48650520bc5f04a8b9f81183679ee";
		String appKey = "4ce9ca6ed88322683c5a63568e21f1dd";
		JSONObject paramJSON = new JSONObject();//系统级参数
		JSONObject useParam = new JSONObject();//应用级参数
		if(sign == 1) {
			TAG = "flight.fuwu.otaOrder.export.all";
			useParam.put("startTime", "2018-09-13 00:00:00");
			useParam.put("endTime", "2018-09-13 12:00:00");
		}else if(sign == 2) {
			TAG = "flight.fuwu.otaOrder.export.paid";
		}
		
		paramJSON.put("tag", TAG);
		paramJSON.put("params", useParam);
		
		String getUrl = URL;
		try {
			paramJSON = iniJSONParam(paramJSON,token,appKey);//初始化传入参数
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Iterator<String> it = paramJSON.keySet().iterator();
		StringBuffer paramSB = new StringBuffer();
		while (it.hasNext()) {
			String key = it.next();
			try {
				paramSB.append(key).append("=").append(URLEncoder.encode(paramJSON.getString(key), "utf-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String paramString = paramSB.toString();
		getUrl += "?" + paramString.substring(0, paramString.length() - 1);//获取完整的url
		System.out.println("getUrl: "+getUrl);
		
	}
	
	private JSONObject iniJSONParam(JSONObject jsonParam,String token,String appKey) throws Exception{
		if(null==jsonParam){
			jsonParam = new JSONObject();
		}
		long timestamp=(new Date()).getTime();
		jsonParam.put("token",token);
		jsonParam.put("key", appKey);
		jsonParam.put("createTime",timestamp);
		String sign=makeSgin(jsonParam);
		jsonParam.put("sign",sign);
		return jsonParam;
	}
	
	private String makeSgin(JSONObject paramsJSON) throws Exception{
		//JSON 一级排序
		List<String> keyList = new ArrayList<String>();
		Set<String> sets = paramsJSON.keySet();
		for (String str : sets) {
			keyList.add(str);
		}
		Collections.sort(keyList, String.CASE_INSENSITIVE_ORDER);
		StringBuilder signSourceSB = new StringBuilder();
		for (String str : keyList) {
			String value=paramsJSON.get(str).toString();
			if(value!=null&&value.length()>0){
				signSourceSB.append(str).append("=").append(value);
			}
		}

		String signSourceString=signSourceSB.toString();
		String md5String = signSourceString;
		md5String = Md5Encode(md5String);
		return md5String;
		
	}
	
	private static String Md5Encode(String str) throws Exception{
        StringBuilder sign = new StringBuilder();
		try {
			  MessageDigest md = MessageDigest.getInstance("MD5");
			  byte[] bytes = md.digest(str.getBytes("UTF-8"));
		        for (int i = 0; i < bytes.length; i++) {
		            String hex = Integer.toHexString(bytes[i] & 0xFF);
		            if (hex.length() == 1) {
		                sign.append("0");
		            }
		            sign.append(hex.toLowerCase());
		        }
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
        return sign.toString();
   }

}
