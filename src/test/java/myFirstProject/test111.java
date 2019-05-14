package myFirstProject;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myFirstProject.mode.emp;

public class test111 {
	
	@Test
	public void test() {
	 int x = 0;
	 int y = 1;
	 int z = 6;
	 int e = 5;
	 
	 if(x==0 && y == 1 && (z==2 || e == 5)) {
		 System.out.println("11111");
	 }else {
		 System.out.println("22222");
	 }
	 
	}
	
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	@Test
	public void test99() {
		
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy K:m:s a",Locale.ENGLISH);
	Date d2 = null;
	try {
	d2 = sdf.parse("Sep 29, 2012 1:00:01 AM");
	} catch (ParseException e) {
	e.printStackTrace();
	}
	Date d3 = new Date();
	System.out.println("d2 ====== "+d2);
	System.out.println("d3 ====== "+sdf.format(d3));
	
	
	}
	
	
	public static String mul(String v1, String v2) {
//		if(v1==null || v1.equals(""))
//			v1="0";
//		if(v2==null || v2.equals(""))
//			v2="0";
		if (StringUtils.isEmpty(v1)){
			v1="0";
		}
		if (StringUtils.isEmpty(v2)){
			v2="0";
		}

		BigDecimal b1 = null;
		try {
			b1 = new BigDecimal(v1);
		} catch (Exception e) {
//			e.printStackTrace();
			b1=new BigDecimal(0);
		}

		BigDecimal b2 = null;
		try {
			b2 = new BigDecimal(v2);
		} catch (Exception e) {
//			e.printStackTrace();
			b2 = new BigDecimal(0);
		}
		return b1.multiply(b2).toString();

	}
	
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}
	
	
	
	public static String getEnDate(String date) throws ParseException{
    	SimpleDateFormat sdf_us = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
    	String[] str = sdf_us.parse(date).toString().split(" ");
    	return Integer.parseInt(str[2])+str[1];
    }
	
	@Test
	public void test20() {
		try {
			String enDate = getEnDate("2018-12-31");
			System.out.println(enDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test19() {
		String str = "";
		str = String.format("订单ID:%s,店铺:%s,平台:%s,价格:%s", "123",5,true,555);
		System.out.println(str);
		
	}
	
	@Test
	public void test18() {
		String str = "324213sadfs1235555-";
		String substring = str.substring(0,str.length()-1);
		System.out.println(substring);
	}
	
	@Test
	public void test17() {
		String xx = "";
		String xxx = "";
		String[] split = xx.split(";");
		for (int i = 0; i < split.length; i++) {
			if(xxx.indexOf(split[i]) == -1) {
				xxx += split[i]+";";
			}
		}
		System.out.println("xx"+xxx);
		System.out.println("xxx"+xxx.substring(0,xxx.length()-1));
	}
	
	@Test
	public void test16() {
		PlalindromeString ps = new PlalindromeString();

		String str = "asdfasdfs555555dASDGVS";
        System.out.println(ps.findLongestPlalindromeString(str));
	}
	
	@Test
	public void test15() throws ParseException {

		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int MILLISECOND_TURN_DAYS = 1000 * 3600 * 24;
		Calendar calendarEarly = Calendar.getInstance();
		Calendar calendarLate = Calendar.getInstance();
		calendarEarly.setTime(new Date());
		calendarLate.setTime(sdf.parse("2019-01-17"));
		// 设置时间为0时
		calendarEarly.set(Calendar.HOUR_OF_DAY, 0);
		calendarEarly.set(Calendar.MINUTE, 0);
		calendarEarly.set(Calendar.SECOND, 0);
		calendarLate.set(Calendar.HOUR_OF_DAY, 0);
		calendarLate.set(Calendar.MINUTE, 0);
		calendarLate.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int number = (int) (calendarLate.getTime().getTime() / MILLISECOND_TURN_DAYS
				- calendarEarly.getTime().getTime() / MILLISECOND_TURN_DAYS);
		System.out.println("差:" + number);
	}
	
	@Test
	public void test14() {
		String str = "123Java456Java789Java";
		Pattern pattern = Pattern.compile("Java");
		System.out.println(pattern.pattern());//返回此模式的正则表达式即Java
		
		String[] result = pattern.split(str);
		for(String s : result)
		    System.out.println(s);
	}
	
	
	
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
		if("2019-01-01 00:00:00".compareTo("2018-01-01 00:00:00") > 0) {
			System.out.println("1111111111111111");
		}else {
			System.out.println("1111111111111111-2");
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
	public void test13() {
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
















