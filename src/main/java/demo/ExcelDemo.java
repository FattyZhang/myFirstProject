package demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import model.ExcelVo;

/**
 * excel 的读取 与 写入
 * @author Administrator
 *
 */
public class ExcelDemo {
	private static final String EXCEL_XLS = ".xls";
	private static final String EXCEL_XLSX = ".xlsx";
	private static final String PATH = "C:\\Users\\Administrator\\Desktop\\";
	private static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat("YYYY-mm-dd");
	
	
	public static void main(String[] args) {
		//String print = "print_ticket_1527125221105";
		String print = "Zyg"+new Date().getTime();
		String finalXlsxPath = PATH+print+EXCEL_XLS;
		//readExcel(finalXlsxPath);
		List<ExcelVo> excelList = new ArrayList<ExcelVo>();
		for(int i=0;i<5;i++) {
			ExcelVo e = new ExcelVo();
			e.setOrderNo(i+"No");
			e.setOrderSource(i+"source");
			e.setShop(i+"shop");
			e.setTime(new Date());
			excelList.add(e);
		}
		writeExcel(excelList, finalXlsxPath);
	}
	
	/**
	 * Excel是我们平时工作中比较常用的用于存储二维表数据的，
	 * JAVA也可以直接对Excel进行操作，
	 * 有两种操作Excel的方式，分别为：jxl和poi。
	 * 在小数据量时jxl快于poi，在大数据量时poi要快于jxl。
	 * 但差距都不明显。 这里使用 jxl
	 */
	/**
	 *读取一个文档 
	 */
	public static void readExcel(String finalXlsxPath) {
		
		try {
			// 读取文档的地址路径
			File file = new File(finalXlsxPath);
			Workbook workBook = Workbook.getWorkbook(file);
			// sheet 对应的一个 工作面
			Sheet sheet = workBook.getSheet(0);
			//获取行数  横
			int rows = sheet.getRows();
			//获取列数 竖
			int cols = sheet.getColumns();
			System.out.println("这个excel表共有:"+rows+"行,和:"+cols+"列");
			List<ExcelVo> excelList = new ArrayList<ExcelVo>();
			for (int row = 3; row < rows; row++){//从第几行 开始取
                ExcelVo excel = new ExcelVo();//将读到的数据转bean
                excel.setOrderNo(sheet.getCell(0, row).getContents()); //取第几列的数据
           	    excel.setOrderSource(sheet.getCell(4, row).getContents());
           	    excel.setShop(sheet.getCell(5, row).getContents());
           	    Date time = SIMPLEDATEFORMAT.parse(sheet.getCell(7, row).getContents());
           	    excel.setTime(time);
           	    excelList.add(excel);
            }
			List<String > strList = new ArrayList<String >();
			for(ExcelVo e: excelList) {
				strList.add(JSON.toJSONString(e));//转json
			}
			System.out.println(strList.toString());
			
		}  catch (Exception e) {
			System.out.println("读取文档错误~"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成一个excel文件
	 */
	public static void writeExcel(List<ExcelVo> excelList,String finalXlsxPath) {
		try {
			//文件的地址和名字
			File file = new File(finalXlsxPath);
			//创建一个工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			//创建一个工作表
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			sheet.addCell(new Label(0, 0,"订单号"));
			sheet.addCell(new Label(1, 0,"订单来源"));
			sheet.addCell(new Label(2, 0,"店铺"));
			sheet.addCell(new Label(3, 0,"时间"));
			for(int row=1;row<excelList.size()+1;row++) {
				ExcelVo e = excelList.get(row-1);
				sheet.addCell(new Label(0, row,e.getOrderNo()));
				sheet.addCell(new Label(1, row,e.getOrderSource()));
				sheet.addCell(new Label(2, row,e.getShop()));
				sheet.addCell(new Label(3, row,e.getTime()+""));
			}
		    workbook.write();
		    workbook.close();
		} catch (Exception e) {
				System.out.println("生成excel表格错误~: "+e.getMessage());
				e.printStackTrace();
			}
	}
	
}










