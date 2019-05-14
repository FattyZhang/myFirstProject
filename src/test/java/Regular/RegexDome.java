package Regular;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDome {
	// 正则表达式的练习
	public static void main(String[] args) {
		// 字符串文本
		String str = "46992654@qq.comasdfasdfsadfasdfasdfa123123@";
		// 创建正则规则
		String regex = "^$";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regex);
//		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);// 忽略大小写
		Matcher matcher = pattern.matcher(str);
		
		if(matcher.find()) {
			String group = matcher.group();
			System.out.println("group:"+group);
		}
		
	}

}
