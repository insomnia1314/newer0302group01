package com.softfactory.pojo;

import java.io.Serializable;

/*
 * create table M_PROCEDURE  (
   ID                   NUMBER(6)                       not null,
   PARENT_ID            NUMBER(6)                       not null,
   DETAILS_NUMBER       NUMBER(6)                       not null,
   PROCEDURE_ID         VARCHAR2(50)                    not null,
   PROCEDURE_NAME       VARCHAR2(50),
   LABOUR_HOUR_AMOUNT   NUMBER(12,2),
   REAL_LABOUR_HOUR_AMOUNT NUMBER(12,2),
   SUBTOTAL             NUMBER(12,2),
   REAL_SUBTOTAL        NUMBER(12,2),
   MODULE_SUBTOTAL      NUMBER(12,2),
   REAL_MODULE_SUBTOTAL NUMBER(12,2),
   COST_PRICE           NUMBER(12,2),
   DEMAND_AMOUNT        NUMBER(12,2),
   REAL_AMOUNT          NUMBER(12,2),
   PROCEDURE_FINISH_TAG VARCHAR2(20)                    not null,
   PROCEDURE_TRANSFER_TAG VARCHAR2(20)                    not null,
 */
public class MProcedure implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 序号
	private Integer parentId; // 派工单序号
	private Integer detailsNumber; // 工序序号
	private String procedureId; // 工序编号
	private String procedureName; // 工序名称
	private double labourHourAmount; // 设计工时数
	private double realLabourHourAmount;// 实际工时数
	private double subtotal; // 设计工时成本
	private double realSubtotal; // 实际工时成本
	private double moduleSubtotal; // 设计物料成本
	private double realModuleSubtotal; // 实际物料成本
	private double costPrice; // 单位工时成本
	private double demandAmount; // 需求数量
	private double realAmount; // 实际数量
	private String procedureFinishTag; // 工序完成标志
	private String procedureTransferTag;// 工序交接标志

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

	public String getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(String procedureId) {
		this.procedureId = procedureId;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public double getLabourHourAmount() {
		return labourHourAmount;
	}

	public void setLabourHourAmount(double labourHourAmount) {
		this.labourHourAmount = labourHourAmount;
	}

	public double getRealLabourHourAmount() {
		return realLabourHourAmount;
	}

	public void setRealLabourHourAmount(double realLabourHourAmount) {
		this.realLabourHourAmount = realLabourHourAmount;
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

	public double getModuleSubtotal() {
		return moduleSubtotal;
	}

	public void setModuleSubtotal(double moduleSubtotal) {
		this.moduleSubtotal = moduleSubtotal;
	}

	public double getRealModuleSubtotal() {
		return realModuleSubtotal;
	}

	public void setRealModuleSubtotal(double realModuleSubtotal) {
		this.realModuleSubtotal = realModuleSubtotal;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getDemandAmount() {
		return demandAmount;
	}

	public void setDemandAmount(double demandAmount) {
		this.demandAmount = demandAmount;
	}

	public double getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(double realAmount) {
		this.realAmount = realAmount;
	}

	public String getProcedureFinishTag() {
		return procedureFinishTag;
	}

	public void setProcedureFinishTag(String procedureFinishTag) {
		this.procedureFinishTag = procedureFinishTag;
	}

	public String getProcedureTransferTag() {
		return procedureTransferTag;
	}

	public void setProcedureTransferTag(String procedureTransferTag) {
		this.procedureTransferTag = procedureTransferTag;
	}

}
