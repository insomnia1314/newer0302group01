package com.softfactory.pojo;

import java.io.Serializable;

/*
 * create table M_PROCEDURE_MODULE  (
   ID                   NUMBER(6)                       not null,
   PARENT_ID            NUMBER(6)                       not null,
   DETAILS_NUMBER       NUMBER(6)                       not null,
   PRODUCT_ID           VARCHAR2(50)                    not null,
   PRODUCT_NAME         VARCHAR2(50),
   COST_PRICE           NUMBER(12,2),
   AMOUNT               NUMBER(12,2),
   RENEW_AMOUNT         NUMBER(12,2),
   REAL_AMOUNT          NUMBER(12,2),
   SUBTOTAL             NUMBER(12,2),
   REAL_SUBTOTAL        NUMBER(12,2),
 */
public class MProcedureModule implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 序号
	private Integer parentId; // 派工单工序序号
	private Integer detailsNumber; // 本工序物料序号
	private String productId; // 产品编号
	private String productName; // 产品名称
	private double costPrice; // 物料单价
	private double amount; // 数量
	private double renewAmount; // 补充数量
	private double realAmount; // 实际数量
	private double subtotal; // 物料小计
	private double realSubtotal; // 实际物料小计
	private String productDescribe;// 描述
	private String amountUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDetailsNumber() {
		return detailsNumber;
	}

	public void setDetailsNumber(Integer detailsNumber) {
		this.detailsNumber = detailsNumber;
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

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRenewAmount() {
		return renewAmount;
	}

	public void setRenewAmount(double renewAmount) {
		this.renewAmount = renewAmount;
	}

	public double getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(double realAmount) {
		this.realAmount = realAmount;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getRealSubtotal() {
		return realSubtotal;
	}

	public void setRealSubtotal(double realSubtotal) {
		this.realSubtotal = realSubtotal;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

}
