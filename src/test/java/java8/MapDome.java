package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class MapDome {

	@Test
	public void putIfAbsent() {
	    Map<String, String> map = new HashMap<>();
	    map.putIfAbsent("key1", "oldValue");
	    // 如果key存在，则忽略put操作
	    map.putIfAbsent("key", "newValue");
	    String value = map.get("key");
	    System.out.println(value);
	}

	@Test
	public void forEach() {
	    Map<String, String> map = new HashMap<>();
	    map.putIfAbsent("key1", "value1");
	    map.putIfAbsent("key2", "value1");
	    map.putIfAbsent("key3", "value1");

	    map.forEach((k,y) -> {
	    	System.out.println(k);
	    	System.out.println(y);
	    });
	    System.out.println("-----------------");
	    map.put("k1", "k1value1");
	    map.put("k2", "k1value2");
	    map.put("k3", "k1value3");
	    map.put("k4", "k1value4");
	    
	    map.forEach((k,v)->{
	    	System.out.println("K:"+k);
	    	System.out.println("v:"+v);
	    });
	    
	    System.out.println("-----------------");
	    Set<String> keySet = map.keySet();
	    for(String k : keySet) {
	    	System.out.println("11"+map.get(k));
	    }
	}

	@Test
	public void computeIfPresent() {
	    Map<String, String> map = new HashMap<>();
	    map.putIfAbsent("key1", "value1");

	    // 如果存在则计算：先判断key是否存在，如果key存在，将BiFunction计算的结果作为key的新值重新put进去
	    map.computeIfPresent("key1", (key, value) -> key + "=" + value);
	    String value = map.get("key1");
	    System.out.println(value);

	    // 如果计算的结果为null，相当于从map中移除
//	    map.computeIfPresent("key1", (k, v) -> null);
//	    boolean contain = map.containsKey("key1");
//	    System.out.println(contain);
	}

	@Test
	public void computeIfAbsent() {
	    // 如果key不存在则将计算的结果put进去
	    Map<String, String> map = new HashMap<>();
	    map.computeIfAbsent("key2", v -> "value2");
	    boolean contain = map.containsKey("key2");
	    String value = map.get("key2");
	    System.out.println(contain);
	    System.out.println(value);
	}

	@Test
	public void remove(){
	    Map<String, String> map = new HashMap<>();
	    map.putIfAbsent("key1", "value1");
	    boolean result = map.remove("key1", "value1");
	    String v = map.get("key1");
	    System.out.println(result);
	    System.out.println(v);
	}

	@Test
	public void getOrDefault(){
	    Map<String, String> map = new HashMap<>();
	    String value = map.getOrDefault("key1", "default value");
	    System.out.println(value);
	}

	@Test
	public void merge(){ 
	    Map<String, String> map = new HashMap<>();
	    map.put("key1", "value1");
	    map.merge("key1", "newValue", (value, newValue) -> value + "-" + newValue);
	    String value = map.get("key1");
	    // value1-newValue
	    System.out.println(value);
	}
	
}
