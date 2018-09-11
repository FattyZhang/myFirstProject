package demo;
/**
 * fastJson的使用
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import model.JSONVo;

public class JSONDemo {

	/**
	 * model转JSON
	 */
	@Test
	public void test1() {
		JSONVo jsonVo = new JSONVo();
		jsonVo.setId(1);
		jsonVo.setName("张三");
		jsonVo.setTime(new Date());
		JSONObject json = (JSONObject) JSON.toJSON(jsonVo);
		System.out.println(json);
		String jsonStr = JSON.toJSONString(jsonVo);
		System.out.println(jsonStr);
	}
	
	/**
	 * JSON格式的字符串转json
	 */
	@Test
	public void test2() {
		String jsonStr = "{\"id\":1,\"name\":\"张三\",\"time\":1527151012852}";
		JSONObject json = JSONObject.parseObject(jsonStr);
		Integer id = Integer.parseInt(json.getString("id"));
		String name = json.getString("name");
		System.out.println("id: "+id+",name: "+name);
		System.out.println(json.toJSONString());
	}
	
	/**
	 * json对象直接转model
	 */
	@Test
	public void test3() {
		JSONObject json = JSONObject.parseObject("{\"id\":1,\"name\":\"张三\",\"time\":1527151012852}");
		JSONVo vo = JSONObject.toJavaObject(json, JSONVo.class);
		System.out.println(vo.toString());
	}
	
	/**
	 * JSONArray
	 */
	@Test
	public void test4() {
		// add
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<3;i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id_"+i, 1);
			jsonObject.put("name_"+i, "zyg");
			jsonObject.put("date_"+i, new Date());
			jsonArray.add(jsonObject);
		}
		String allStr = jsonArray.toJSONString();
		System.out.println(allStr);
		
		//遍历
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject json = jsonArray.getJSONObject(i);
			System.out.println(json.toJSONString());
		}
		
	}
	
	@Test
	public void test5() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("169-7125888195", "校验成功");
		map.put("169-7125888196", "校验成功");
		
		JSONObject json = new JSONObject();
		json.put("id", "111");
		json.put("ticketStatus", map);
		System.out.println(json.toString());
		
		Map<String, String> map1 = (Map<String, String>) json.get("ticketStatus");
		System.out.println(map1);
		for(String key : map1.keySet()) {
			System.out.println(key);
			System.out.println(map1.get(key));
		}
		
	}	
}










