package com.softfactory.pojo;

import java.io.Serializable;

/**
 * 生产工序物料过程记录
 * 
 * @author GuangxiangLong
 *
 */

public class MProcedureModuling implements Serializable {

	private static final long serialVersionUID = 3726082431537144304L;

	private Integer mPId; // 主键序号
	private Integer parentId; // 派工单工序序号
	private Integer detailsNumber; // 本工序物料序号
	private String producId; // 产品编号
	private String productName; // 产品名称
	private double costPrice; // 单位物料成本
	private double amount; // 本次使用数量
	private double subtotal; // 物料成本

	public Integer getmPId() {
		return mPId;
	}

	public void setmPId(Integer mPId) {
		this.mPId = mPId;
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

	public String getProducId() {
		return producId;
	}

	public void setProducId(String producId) {
		this.producId = producId;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String toString() {
		return "MProcedureModuling [mPId=" + mPId + ", parentId=" + parentId + ", detailsNumber=" + detailsNumber
				+ ", producId=" + producId + ", productName=" + productName + ", costPrice=" + costPrice + ", amount="
				+ amount + ", subtotal=" + subtotal + "]";
	}
}
