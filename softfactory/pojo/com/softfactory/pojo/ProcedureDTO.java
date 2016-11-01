package com.softfactory.pojo;

public class ProcedureDTO {
	private String productName;
	private String DesignId;
	private String productId;
	private String procedureId;
	private Integer detailsNumber;
	private String procedureName;

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

	public String getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(String procedureId) {
		this.procedureId = procedureId;
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

	public String getDesignId() {
		return DesignId;
	}

	public void setDesignId(String designId) {
		DesignId = designId;
	}

	@Override
	public String toString() {
		return "ProcedureDTO [productName=" + productName + ", DesignId="
				+ DesignId + "]";
	}

}
