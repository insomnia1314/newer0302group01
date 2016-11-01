package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Procedure implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String designId;// 工序设计单编号
	private String productId;// 产品编号
	private String productName;// 产品名称
	private String designer;// 设计人
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:ss:mm")
	private Date registerTime;// 登记时间
	@NumberFormat(pattern = "xxx.xx")
	private Double costPriceSum;// 工时总成本
	@NumberFormat(pattern = "xxx.xx")
	private Double moduleCostPriceSum;// 物料总成本
	private String procedureDescribe;// 设计要求
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:ss:mm")
	private Date checkTime;// 审核时间
	private String checker;// 复核人
	private String procedureName;// 工序名称
	private Integer detailsNumber;// 工序编号
	private String prcedureId;// 工序单编号
	private String gongxumiaoshu;// 工序描述
	private Double labourHourAmount;// 工时数
	@NumberFormat(pattern = "xxx.xx")
	private Double subtotal;// 公时成本小计
	private Double moduleSubtotal;// 物料成本小计
	private Integer zhujian;// 工序主键ID
	private Double amount;// 数量
	private String amountUnit;// 单位
	private Double costPrice;// 单位工时成本
	private Integer fk;// 设计单序号
	private String type;// 物料类型
	private String productName1;// 物料名称

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getProductName1() {
		return productName1;
	}

	public void setProductName1(String productName1) {
		this.productName1 = productName1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
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

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Double getCostPriceSum() {
		return costPriceSum;
	}

	public void setCostPriceSum(Double costPriceSum) {
		this.costPriceSum = costPriceSum;
	}

	public Double getModuleCostPriceSum() {
		return moduleCostPriceSum;
	}

	public void setModuleCostPriceSum(Double moduleCostPriceSum) {
		this.moduleCostPriceSum = moduleCostPriceSum;
	}

	public String getProcedureDescribe() {
		return procedureDescribe;
	}

	public void setProcedureDescribe(String procedureDescribe) {
		this.procedureDescribe = procedureDescribe;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public Integer getDetailsNumber() {
		return detailsNumber;
	}

	public void setDetailsNumber(Integer detailsNumber) {
		this.detailsNumber = detailsNumber;
	}

	public String getPrcedureId() {
		return prcedureId;
	}

	public void setPrcedureId(String prcedureId) {
		this.prcedureId = prcedureId;
	}

	public String getGongxumiaoshu() {
		return gongxumiaoshu;
	}

	public void setGongxumiaoshu(String gongxumiaoshu) {
		this.gongxumiaoshu = gongxumiaoshu;
	}

	public Double getLabourHourAmount() {
		return labourHourAmount;
	}

	public void setLabourHourAmount(Double labourHourAmount) {
		this.labourHourAmount = labourHourAmount;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getModuleSubtotal() {
		return moduleSubtotal;
	}

	public void setModuleSubtotal(Double moduleSubtotal) {
		this.moduleSubtotal = moduleSubtotal;
	}

	public Integer getZhujian() {
		return zhujian;
	}

	public void setZhujian(Integer zhujian) {
		this.zhujian = zhujian;
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

	public Integer getFk() {
		return fk;
	}

	public void setFk(Integer fk) {
		this.fk = fk;
	}

	@Override
	public String toString() {
		return "Procedure [Id=" + Id + ", designId=" + designId
				+ ", productId=" + productId + ", productName=" + productName
				+ ", designer=" + designer + ", registerTime=" + registerTime
				+ ", costPriceSum=" + costPriceSum + ", moduleCostPriceSum="
				+ moduleCostPriceSum + ", procedureDescribe="
				+ procedureDescribe + ", checkTime=" + checkTime
				+ ", procedureName=" + procedureName + ", detailsNumber="
				+ detailsNumber + ", prcedureId=" + prcedureId
				+ ", gongxumiaoshu=" + gongxumiaoshu + ", labourHourAmount="
				+ labourHourAmount + ", subtotal=" + subtotal
				+ ", moduleSubtotal=" + moduleSubtotal + ", zhujian=" + zhujian
				+ ", amount=" + amount + ", amountUnit=" + amountUnit
				+ ", costPrice=" + costPrice + ", fk=" + fk + ", type=" + type
				+ ", productName1=" + productName1 + "]";
	}

}
