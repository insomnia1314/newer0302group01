package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存单元实体类  实体实现
 * 
 * @author zhouyelong
 * 
 */
public class Scell implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; // 序号
	private String stroeId; // 库存编号
	private String productId; // 产品编号
	private String productName; // 产品名称
	private String firstKingId; // 产品一级分类编号
	private String firstKingName; // 产品一级分类名称
	private String secondKingId; // 产品二级分类编号
	private String secondKingName; // 产品二级分类名称
	private String thirdKingId; // 产品三级级分类编号
	private String thirdKingName; // 产品三级分类名称
	private Long minAmount; // 产品报警下限
	private Long maxAmount; // 产品报警上限
	private Long maxCapacityAmount; // 最大存储量
	private Long aount; // 当前存储量
	private String config; // 配置要求
	private String register; // 登记人
	private Date registerTime; // 登记时间
	private String checker; // 复核人
	private String checkTime; // 复核时间
	private String checkTag; // 审核标记

	public Scell() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStroeId() {
		return stroeId;
	}

	public void setStroeId(String stroeId) {
		this.stroeId = stroeId;
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

	public String getFirstKingId() {
		return firstKingId;
	}

	public void setFirstKingId(String firstKingId) {
		this.firstKingId = firstKingId;
	}

	public String getFirstKingName() {
		return firstKingName;
	}

	public void setFirstKingName(String firstKingName) {
		this.firstKingName = firstKingName;
	}

	public String getSecondKingId() {
		return secondKingId;
	}

	public void setSecondKingId(String secondKingId) {
		this.secondKingId = secondKingId;
	}

	public String getSecondKingName() {
		return secondKingName;
	}

	public void setSecondKingName(String secondKingName) {
		this.secondKingName = secondKingName;
	}

	public String getThirdKingId() {
		return thirdKingId;
	}

	public void setThirdKingId(String thirdKingId) {
		this.thirdKingId = thirdKingId;
	}

	public String getThirdKingName() {
		return thirdKingName;
	}

	public void setThirdKingName(String thirdKingName) {
		this.thirdKingName = thirdKingName;
	}

	public Long getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	public Long getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Long maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Long getMaxCapacityAmount() {
		return maxCapacityAmount;
	}

	public void setMaxCapacityAmount(Long maxCapacityAmount) {
		this.maxCapacityAmount = maxCapacityAmount;
	}

	public Long getAount() {
		return aount;
	}

	public void setAount(Long aount) {
		this.aount = aount;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
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

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckTag() {
		return checkTag;
	}

	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}

}
