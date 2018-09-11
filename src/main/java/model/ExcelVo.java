package model;

import java.io.Serializable;
import java.util.Date;

public class ExcelVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9082976381511934063L;

	
	private String orderNo;
	private String orderSource;
	private String shop;
	private Date time;
	
	
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "excelVo [orderNo=" + orderNo + ", orderSource=" + orderSource + ", shop=" + shop + ", time=" + time
				+ "]";
	}
	
}
