package com.softfactory.pojo;

import java.io.Serializable;

public class Pdetails implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 序号
	private Integer parentId; // 产品序号
	private String procedureName; // 工序名称
	private String procedureId; // 工序编号
	private String procedureDescribe;// 描述
	private double labourHourAmount;// 工时数
	private double costPrice; // 单位工时成本
	private double subtotal; // 工时成本小计
	private String productId;// 产品编号

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

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(String procedureId) {
		this.procedureId = procedureId;
	}

	public String getProcedureDescribe() {
		return procedureDescribe;
	}

	public void setProcedureDescribe(String procedureDescribe) {
		this.procedureDescribe = procedureDescribe;
	}

	public double getLabourHourAmount() {
		return labourHourAmount;
	}

	public void setLabourHourAmount(double labourHourAmount) {
		this.labourHourAmount = labourHourAmount;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
