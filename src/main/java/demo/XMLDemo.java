package demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import model.XmlVo;

/**
 * 利用dom4j 解析XML
 * @author Administrator
 *
 */
public class XMLDemo {
	/*
	 *Document - 表示整个XML文档。文档Document对象是通常被称为DOM树。
	 *Element - 表示一个XML元素。 Element对象有方法来操作其子元素，它的文本，属性和名称空间。
	 *Attribute - 表示元素的属性。属性有方法来获取和设置属性的值。它有父节点和属性类型。
	 *Node - 代表元素，属性或处理指令
	 */
	
	/**
	 * 解析一个xml
	 * xml转bean
	 */
	public static void  analysisXML() {
		try {
			//获取xml文件
			File file = new File("src//main//java//model//zyg6274.xml");
			//创建saxReader对象  
	        SAXReader reader = new SAXReader(); 
	        //读取xml文件
			Document document = reader.read(file);
			//获取根节点 只有一个 只能获取一次
			Element root = document.getRootElement();
			/*-----------------------------------------------*/
			//获取元素下指定的标签
			Element xmlName = root.element("xmlName");
			//获取标签的text
			String textName = xmlName.getTextTrim();
			//获取标签内指定属性的内容
			String valueName = xmlName.attributeValue("Name");
			System.out.println("textName: "+textName+", valueName: "+valueName);
			/*-----------------------------------------------*/
			//获取标签下的所有子节点                     
			List<Element> eleme = root.elements();
			for(Element e : eleme) {
				System.out.println("所有节点的名字:"+e.getName());
				System.out.println("所有节点的值:"+e.getTextTrim());
				//getStringValue() 会吧此节点下的子节点的text也输出出来
				System.out.println("所有节点的值:"+e.getStringValue());
			}
			
			//获取当前标签的所有 属性
			List<Attribute> list = root.attributes();
			for(Attribute  e : list) {
				System.out.println("name:"+e.getName()+" ,value:"+e.getStringValue());
			}
			//把xml 转 String
			String xmlString = document.asXML();
			System.out.println("xml转换为完正的String: "+xmlString);
			
		} catch (Exception e) {
			System.out.println("解析XML失败: "+e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	/**
	 * 递归遍历全部内容
	 * @param node
	 */
	public static void listNodes(Element node) {  
        System.out.println("当前节点的名称：：" + node.getName());  
        // 获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        // 遍历属性节点  
        for (Attribute attr : list) {  
            System.out.println(attr.getText() + "-----" + attr.getName()  
                    + "---" + attr.getValue());  
        }  

        if (!(node.getTextTrim().equals(""))) {  
            System.out.println("文本内容：：：：" + node.getText());  
        }  
        ////////////////// 获取节点下面TripList节点下所有的RangeInfo信息
        List<Element> rangeInfoElementList = node.selectNodes("//TripList//RangeInfo");
        // 当前节点下面子节点迭代器  
        Iterator<Element> it = node.elementIterator();  
        // 遍历  
        while (it.hasNext()) {  
            // 获取某个子节点对象  
            Element e = it.next();  
            // 对子节点进行遍历  
            listNodes(e);  
        }  
    }  

	

	/**
	 * 生成一个xml文件
	 * 
	 */
	public static void ModelSwitchXML(XmlVo xml) {
		try {
			//Document - 表示整个XML文档。文档Document对象是通常被称为DOM树。
			Document document = DocumentHelper.createDocument();
			//根标签
			Element root = document.addElement("Model");
			//子标签
			Element xmlName = root.addElement("xmlName");
			//子标签 添加内容
			xmlName.addText(xml.getName());
			//子标签 添加属性
			xmlName.addAttribute("Name", xml.getName());
			
			//注意父类是谁~
			root.addElement("xmlJob").addText(xml.getJob()).addAttribute("Job", xml.getJob());
			root.addElement("xmlId").addText(xml.getId()+"").addAttribute("Id", xml.getId()+"");
			
			String xmlString = document.asXML();
			System.out.println("xmlString: "+xmlString);
			// 生成xml 如果不需要生成这个文件 忽略下面的内容
			// 紧凑的格式  
			// OutputFormat format = OutputFormat.createCompactFormat();  
			// 排版缩进的格式  
			/*OutputFormat format = OutputFormat.createPrettyPrint();  
			format.setEncoding("utf-8");
			String str = new Date().getTime()+"";
			str = str.substring(str.length()-4, str.length());
			//创建流 文件的路径 字符集
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(  
						new FileOutputStream(new File("src//main//java//model//zyg"+str+".xml")), "UTF-8"), format);
			//写入
			writer.write(document);
			//立刻写入
			writer.flush();
			//关闭
			writer.close();*/
		}  catch (Exception e) {
			System.out.println("生成xml错误:"+e.getMessage());
			e.printStackTrace();
		}  
		
	}
	
	
	public static void main(String[] args) {
		XmlVo xmlVo = new XmlVo();
		xmlVo.setId(1);
		xmlVo.setJob("出票");
		xmlVo.setName("张三");
		xmlVo.setTime(new Date());
		ModelSwitchXML(xmlVo);
		//analysisXML();
		
	}
	
}





