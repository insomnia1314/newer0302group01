package com.softfactory.pojo;

import java.io.Serializable;

public class Insert implements Serializable{

	private String productId;// 物料编号
	private String productName;// 产品名称
	private String productName1;// 物料名称
	private double amount;// 工时数
	private String amountUnit;// 单位
	private double costPrice;// 小计
	private String type;// 类型
	private Integer detailsNumber;// 工序编号
	private Integer parentId;// 父类ID
	private Integer Id;// 主键
	private double subtotal;// 小计

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

	public String getProductName1() {
		return productName1;
	}

	public void setProductName1(String productName1) {
		this.productName1 = productName1;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDetailsNumber() {
		return detailsNumber;
	}

	public void setDetailsNumber(Integer detailsNumber) {
		this.detailsNumber = detailsNumber;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "Insert [productId=" + productId + ", productName="
				+ productName + ", productName1=" + productName1 + ", amount="
				+ amount + ", amountUnit=" + amountUnit + ", costPrice="
				+ costPrice + ", type=" + type + ", detailsNumber="
				+ detailsNumber + ", parentId=" + parentId + ", Id=" + Id
				+ ", subtotal=" + subtotal + "]";
	}

}
