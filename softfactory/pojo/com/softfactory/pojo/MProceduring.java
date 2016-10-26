package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 生产工序物料过程记录
 * 
 * @author GuangxiangLong
 *
 */

public class MProceduring implements Serializable {

	private static final long serialVersionUID = -5900185808975822112L;

	private Integer mPMId; // 主键序号
	private Integer parentId; // 派工单序号
	private Integer detailsNumber; // 工序序号
	private String procedureId; // 工序编号
	private String procedureName; // 工序名称
	private double labourHourAmount; // 本次工时数
	private double costPrice; // 单位工时成本
	private double subtotal; // 工时成本小计
	private String procedureDescribe; // 工序描述
	private double regCount; // 登记次数
	private String procedureResponsiblePerson;// 负责人
	private String register;// 登记人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerTime;// 登记时间
	private String checker;// 审核人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date checkTime;// 审核时间

	public Integer getmPMId() {
		return mPMId;
	}

	public void setmPMId(Integer mPMId) {
		this.mPMId = mPMId;
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

	public String getProcedureDescribe() {
		return procedureDescribe;
	}

	public void setProcedureDescribe(String procedureDescribe) {
		this.procedureDescribe = procedureDescribe;
	}

	public double getRegCount() {
		return regCount;
	}

	public void setRegCount(double regCount) {
		this.regCount = regCount;
	}

	public String getProcedureResponsiblePerson() {
		return procedureResponsiblePerson;
	}

	public void setProcedureResponsiblePerson(String procedureResponsiblePerson) {
		this.procedureResponsiblePerson = procedureResponsiblePerson;
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

	@Override
	public String toString() {
		return "MProceduring [mPMId=" + mPMId + ", parentId=" + parentId + ", detailsNumber=" + detailsNumber
				+ ", procedureId=" + procedureId + ", procedureName=" + procedureName + ", labourHourAmount="
				+ labourHourAmount + ", costPrice=" + costPrice + ", subtotal=" + subtotal + ", procedureDescribe="
				+ procedureDescribe + ", regCount=" + regCount + ", procedureResponsiblePerson="
				+ procedureResponsiblePerson + ", register=" + register + ", registerTime=" + registerTime
				+ ", checker=" + checker + ", checkTime=" + checkTime + "]";
	}
}
