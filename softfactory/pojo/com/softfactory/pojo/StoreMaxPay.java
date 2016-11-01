package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 出库单
 * @author asus
 *
 */

public class StoreMaxPay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;       //出库单序号
	private String payId;     //出库单编号
	private String storer;     //出库人
	private String reason;        //出库理由
	private String reasonExact;    //出库详细理由
	private double amountSum;    //总件数
	private double costPriceSum;   //总金额
	private double paidAmountSum;  //本次出库总件数
	private String remark ;  //备注
    private String register;  //登记人
    private Date registerTime; //登记时间
    private String checker;  //复核人
    private Date checkTime; //复核时间
    private String checkTag; //复核标志S001-0: 等待审核S001-1: 审核通过  S001-2: 审核不通过
    private String attemper; //调度人
    private Date attemperTime;//调度时间
    private String storeTag; //库存标志 K002-1: 已登记   K002-2: 已调度
    /**
     * 无参构造方法
     */
	    public StoreMaxPay() {
	}
      /**
       * 提供get和set方法
       */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getStorer() {
		return storer;
	}
	public void setStorer(String storer) {
		this.storer = storer;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReasonExact() {
		return reasonExact;
	}
	public void setReasonExact(String reasonExact) {
		this.reasonExact = reasonExact;
	}
	public double getAmountSum() {
		return amountSum;
	}
	public void setAmountSum(double amountSum) {
		this.amountSum = amountSum;
	}
	public double getCostPriceSum() {
		return costPriceSum;
	}
	public void setCostPriceSum(double costPriceSum) {
		this.costPriceSum = costPriceSum;
	}
	public double getPaidAmountSum() {
		return paidAmountSum;
	}
	public void setPaidAmountSum(double paidAmountSum) {
		this.paidAmountSum = paidAmountSum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getCheckTag() {
		return checkTag;
	}
	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}
	public String getAttemper() {
		return attemper;
	}
	public void setAttemper(String attemper) {
		this.attemper = attemper;
	}
	public Date getAttemperTime() {
		return attemperTime;
	}
	public void setAttemperTime(Date attemperTime) {
		this.attemperTime = attemperTime;
	}
	public String getStoreTag() {
		return storeTag;
	}
	public void setStoreTag(String storeTag) {
		this.storeTag = storeTag;
	}
	
     }
