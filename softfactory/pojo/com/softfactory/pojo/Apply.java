package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 生产计划
 * 
 * @author Administrator
 *
 */
public class Apply implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 主键
	private String applyId; // 计划单编号
	private String productId; // 产品编号
	private String productName; // 产品名称
	private String productDescribe;// 描述
	private double amount; // 数量
	private String register; // 登记人

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerTime; // 登记时间

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date checkTime; // 审核时间
	private String checkTag; // 审核状态
	private String manufactureTag;// 派工标志
	private String remark; // 备注

	public Apply() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
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

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckTag() {
		return checkTag;
	}

	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}

	public String getManufactureTag() {
		return manufactureTag;
	}

	public void setManufactureTag(String manufactureTag) {
		this.manufactureTag = manufactureTag;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
