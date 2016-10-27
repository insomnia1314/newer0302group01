package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * create table M_MANUFACTURE  (
   ID                   NUMBER(6)                       not null,
   MANUFACTURE_ID       VARCHAR2(50)                    not null,
   PRODUCT_ID           VARCHAR2(50)                    not null,
   PRODUCT_NAME         VARCHAR2(50),
   AMOUNT               NUMBER(12,2)                    not null,
   TESTED_AMOUNT        NUMBER(12,2),
   APPLY_ID_GROUP       VARCHAR2(400)                   not null,
   PRODUCT_DESCRIBE     VARCHAR2(400),
   MODULE_COST_PRICE_SUM NUMBER(12,2),
   REAL_MODULE_COST_PRICE_SUM NUMBER(12,2),
   LABOUR_COST_PRICE_SUM NUMBER(12,2),
   REAL_LABOUR_COST_PRICE_SUM NUMBER(12,2),
   DESIGNER             VARCHAR2(50),
   REGISTER             VARCHAR2(50),
   REGISTER_TIME        DATE,
   CHECKER              VARCHAR2(50),
   CHECK_TIME           DATE,
   REMARK               VARCHAR2(400),
   CHECK_TAG            VARCHAR2(20)                    not null,
   MANUFACTURE_PROCEDURE_TAG VARCHAR2(20)                    not null,
 */
public class Manufacture implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 序号
	private String manufactureId; // 派工单编号
	private String productId; // 产品编号
	private String productName; // 产品名称
	private double amount; // 投产数量
	private double testedAmount; // 合格数量
	private String applyIdGroup; // 生产计划序号组
	private String productDescribe; // 产品描述
	private double moduleCostPriceSum;// 设计物料总成本
	private double realModuleCostPriceSum;// 实际物料总成本
	private double labourCostPriceSum;// 设计工时总成本
	private double realLabourCostPriceSum;// 实际工时总成本
	private String designer; // 工单制定人
	private String register; // 登记人
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date registerTime; // 登记时间
	private String checker; // 审核人
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date checkTime; // 审核时间
	private String remark; // 备注
	private String checkTag; // 审核标志
	private String manufactureProcedureTag;// 生产过程标记
	
	
	
	public Manufacture() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(String manufactureId) {
		this.manufactureId = manufactureId;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTestedAmount() {
		return testedAmount;
	}

	public void setTestedAmount(double testedAmount) {
		this.testedAmount = testedAmount;
	}

	public String getApplyIdGroup() {
		return applyIdGroup;
	}

	public void setApplyIdGroup(String applyIdGroup) {
		this.applyIdGroup = applyIdGroup;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public double getModuleCostPriceSum() {
		return moduleCostPriceSum;
	}

	public void setModuleCostPriceSum(double moduleCostPriceSum) {
		this.moduleCostPriceSum = moduleCostPriceSum;
	}

	public double getRealModuleCostPriceSum() {
		return realModuleCostPriceSum;
	}

	public void setRealModuleCostPriceSum(double realModuleCostPriceSum) {
		this.realModuleCostPriceSum = realModuleCostPriceSum;
	}

	public double getLabourCostPriceSum() {
		return labourCostPriceSum;
	}

	public void setLabourCostPriceSum(double labourCostPriceSum) {
		this.labourCostPriceSum = labourCostPriceSum;
	}

	public double getRealLabourCostPriceSum() {
		return realLabourCostPriceSum;
	}

	public void setRealLabourCostPriceSum(double realLabourCostPriceSum) {
		this.realLabourCostPriceSum = realLabourCostPriceSum;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCheckTag() {
		return checkTag;
	}

	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}

	public String getManufactureProcedureTag() {
		return manufactureProcedureTag;
	}

	public void setManufactureProcedureTag(String manufactureProcedureTag) {
		this.manufactureProcedureTag = manufactureProcedureTag;
	}

}
