package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MProcedureDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer mprid; // 序号
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
	//***************************//
	private Integer manid; // 序号
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
	
	
	public Integer getMprid() {
		return mprid;
	}
	public void setMprid(Integer mprid) {
		this.mprid = mprid;
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
	public Integer getManid() {
		return manid;
	}
	public void setManid(Integer manid) {
		this.manid = manid;
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
	@Override
	public String toString() {
		return "MProcedureDTO [mprid=" + mprid + ", parentId=" + parentId + ", detailsNumber=" + detailsNumber
				+ ", procedureId=" + procedureId + ", procedureName=" + procedureName + ", labourHourAmount="
				+ labourHourAmount + ", realLabourHourAmount=" + realLabourHourAmount + ", subtotal=" + subtotal
				+ ", realSubtotal=" + realSubtotal + ", moduleSubtotal=" + moduleSubtotal + ", realModuleSubtotal="
				+ realModuleSubtotal + ", costPrice=" + costPrice + ", demandAmount=" + demandAmount + ", realAmount="
				+ realAmount + ", procedureFinishTag=" + procedureFinishTag + ", procedureTransferTag="
				+ procedureTransferTag + ", manid=" + manid + ", manufactureId=" + manufactureId + ", productId="
				+ productId + ", productName=" + productName + ", amount=" + amount + ", testedAmount=" + testedAmount
				+ ", applyIdGroup=" + applyIdGroup + ", productDescribe=" + productDescribe + ", moduleCostPriceSum="
				+ moduleCostPriceSum + ", realModuleCostPriceSum=" + realModuleCostPriceSum + ", labourCostPriceSum="
				+ labourCostPriceSum + ", realLabourCostPriceSum=" + realLabourCostPriceSum + ", designer=" + designer
				+ ", register=" + register + ", registerTime=" + registerTime + ", checker=" + checker + ", checkTime="
				+ checkTime + ", remark=" + remark + ", checkTag=" + checkTag + ", manufactureProcedureTag="
				+ manufactureProcedureTag + "]";
	}
}