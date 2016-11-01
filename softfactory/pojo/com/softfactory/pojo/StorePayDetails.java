package com.softfactory.pojo;

import java.io.Serializable;

/**
 * 出库明细
 * 
 * @author asus
 *
 */
public class StorePayDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; // 序号 OK
	private String parentId; // 出库单编号
	private String productId; // 产品编号 ------从产品档案查询OK
	private String productName; // 产品名称 ------从产品档案查询OK
	private String productDescribe; // 产品描述 ------从产品档案查询
	private double amount; // 应出库数量 OK
	private double actualAmount;// 实际最后出库数量
	private String amountUnit; // 单位 ------从产品档案查询OK
	private double costPrice; // 单价 ------从产品档案查询OK
	private double subtotal; // 小计 ------------------后台计算OK
	private String dispatch; // 初始化为 D001-0 调度标志

	public StorePayDetails() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getDispatch() {
		return dispatch;
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	public double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
