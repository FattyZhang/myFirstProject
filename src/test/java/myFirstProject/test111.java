package myFirstProject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myFirstProject.mode.emp;

public class test111 {
	
	
	
	
	@Test
	public void test12() {
		String[] x = new String[2];
		x[0] = "1";
		x[1] = "2";
		System.out.println(x.length);
		System.out.println(x);
	}
	
	@Test 
	public void test11() {
		for (int i = 0; i < 5; i++) {
			int x = 3;
			if(i+1 == 3) {
				x = 4;
			}
			System.out.println(i);
			System.out.println(x);
		}
	}
	
	@Test
	public void test10() {
		List<Map<String ,String>> list = new ArrayList<Map<String ,String>>();
		for (int i = 0; i < 3; i++) {
			Map<String ,String > map = new HashMap<String, String>();
			map.put("x", "1+"+i);
			map.put("y", "2+"+i);
			map.put("z", "3+"+i);
			list.add(map);
		}
		System.out.println(list.toString());
		
	}
	
	@Test
	public void test9() {
		String x = "b-c-q-";
		System.out.println(x.substring(0,x.length()-1));
	}
	
	@Test
	public void test8() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ticketDeadline = "1521041280000";
		Date ticketDeadlinedate = new Date();
		ticketDeadlinedate.setTime(new Long(ticketDeadline));
		System.out.println(sdf.format(ticketDeadlinedate));
	}
	
	@Test
	public void test7() {
		String date1 = "2018-08-01";
		String date2 = "2018-07-22";
		if(date2.compareTo(date1) >= 0) {
			System.out.println("2大于1");
		}else if(date2.compareTo(date1) < 0) {
			System.out.println("1大于2");
		}
		
	}
	
	@Test
	public void test6() {
		double x = 1.123;
		double y = 1.123;
		double z = x*y;
		System.out.println("x: "+x+" ,y: "+y+" ,z: "+z);
		x = x*1000;
		y = y*1000;
		double d = x*y;
		d = d/1000000;
		System.out.println("x1: "+x+" ,y1: "+y+" ,d: "+d);
		
		
	}
	
	@Test
	public void test5() {
		int lixi = 208;
		int yjq = 0;
		int whk = 1701 * 5;
		int dk = 17900;
		yjq = lixi * 20;
		int zong = dk+yjq;
		
		System.out.println("贷款: "+dk);
		System.out.println("总利息: "+yjq);
		System.out.println("贷款加利息: "+zong);
		System.out.println("未结清: "+whk);
		System.out.println("已结清: "+(zong-whk));
		
		
	}
	
	@Test
	public void test2() {
		String old = "CA124";
		if(old.length() == 5) {
			String s =  new StringBuffer().append(old.substring(0, 2)).append("0").append(old.substring(2, 5)).toString();
			System.out.println(s);
		}
	}
	
	@Test
	public void test() {
		List<String> list2 = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		for(int i=0;i<3;i++) {
			list1.add("111");
			list1.add("222");
			list1.add("333");
			list2.addAll(list1);
		}
		System.out.println(list2);
	}
	
	@Test
	public void test1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		emp e = new emp();
		e.setId(100);
		e.setUser("qqq");
		e.setPassword("123123123");
		e.setCreatedate(sdf.format(new Date()));
		String obj = JSON.toJSONString(e);
		System.out.println("对象 ==》json ： "+obj);
		JSONObject jsonObj = JSON.parseObject(obj);
		String id = jsonObj.getString("id");
		String name = jsonObj.getString("user");
		emp e1 = new emp();
		e1.setId(Integer.parseInt(id));
		e1.setUser(name);
		System.out.println("Json ==> 对象:"+e1);
	}
	
	@Test
	public void test3() {
		String str="/Date(1487053489965+0800)/";
        str=str.replace("/Date(","").replace(")/","");
        String time = str.substring(0,str.length()-5);
        Date date = new Date(Long.parseLong(time));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.print(format.format(date));
	}
	
	@Test 
	public void test4() {
		Double x = 1.2134;
		Double z = x*0.02;
		System.out.println("x: "+x+", y: "+z);
	}
	
	
	
	public static String reverse(String originStr) {  
        if(originStr == null || originStr.length() <= 1) {
        	System.out.println("xxxxxxxxxx: "+originStr);
        	return originStr;  
        }
        	System.out.println("参数"+originStr);
        	System.out.println("1: "+originStr.substring(1));
        	System.out.println("2: "+originStr.charAt(0));
        	String str= reverse(originStr.substring(1)) + originStr.charAt(0);  
        	System.out.println("单次"+str);
        	return str;
    }  
	public static void main(String[] args) {
	 	/*SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  */
		System.out.println(reverse("world"));;
	}
}
















