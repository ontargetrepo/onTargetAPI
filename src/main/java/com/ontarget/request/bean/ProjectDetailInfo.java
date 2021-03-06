package com.ontarget.request.bean;

import java.sql.Date;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "projectParentId", "projectTypeId", "projectAddress", "companyId", "projectName",
		"projectImagePath", "projectDescription", "status", "startDate", "endDate", "unitOfMeasurement" })
public class ProjectDetailInfo {

	@JsonProperty("projectId")
	private Integer projectId;
	@NotNull
	@JsonProperty("projectParentId")
	private Integer projectParentId;
	@NotNull
	@JsonProperty("projectTypeId")
	private Integer projectTypeId;
	@NotNull
	@Valid
	@JsonProperty("projectAddress")
	private ProjectAddressInfo projectAddress;
	@NotNull
	@JsonProperty("companyId")
	private Integer companyId;
	@NotEmpty
	@JsonProperty("projectName")
	private String projectName;
	@JsonProperty("projectImagePath")
	private String projectImagePath;
	@NotEmpty
	@JsonProperty("projectDescription")
	private String projectDescription;
	@NotEmpty
	@JsonProperty("status")
	private String status;
	@NotNull
	@JsonProperty("startDate")
	private Date startDate;
	@NotNull
	@JsonProperty("endDate")
	private Date endDate;
	@NotEmpty
	@JsonProperty("unitOfMeasurement")
	private String unitOfMeasurement;

    @JsonProperty("projectAssetFolderName")
    private String projectAssetFolderName;

    @JsonProperty("projectAssetFolderName")
    public String getProjectAssetFolderName() {
        return projectAssetFolderName;
    }

    @JsonProperty("projectAssetFolderName")
    public void setProjectAssetFolderName(String projectAssetFolderName) {
        this.projectAssetFolderName = projectAssetFolderName;
    }

    /**
	 * 
	 * @return The projectParentId
	 */
	@JsonProperty("projectParentId")
	public Integer getProjectParentId() {
		return projectParentId;
	}

	/**
	 * 
	 * @param projectParentId
	 *            The projectParentId
	 */
	@JsonProperty("projectParentId")
	public void setProjectParentId(Integer projectParentId) {
		this.projectParentId = projectParentId;
	}

	/**
	 * 
	 * @return The projectTypeId
	 */
	@JsonProperty("projectTypeId")
	public Integer getProjectTypeId() {
		return projectTypeId;
	}

	/**
	 * 
	 * @param projectTypeId
	 *            The projectTypeId
	 */
	@JsonProperty("projectTypeId")
	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	/**
	 * 
	 * @return The projectAddress
	 */
	@JsonProperty("projectAddress")
	public ProjectAddressInfo getProjectAddress() {
		return projectAddress;
	}

	/**
	 * 
	 * @param projectAddress
	 *            The projectAddress
	 */
	@JsonProperty("projectAddress")
	public void setProjectAddress(ProjectAddressInfo projectAddress) {
		this.projectAddress = projectAddress;
	}

	/**
	 * 
	 * @return The companyId
	 */
	@JsonProperty("companyId")
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * 
	 * @param companyId
	 *            The companyId
	 */
	@JsonProperty("companyId")
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 
	 * @return The projectName
	 */
	@JsonProperty("projectName")
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 
	 * @param projectName
	 *            The projectName
	 */
	@JsonProperty("projectName")
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@JsonProperty("projectImagePath")
	public String getProjectImagePath() {
		return projectImagePath;
	}

	@JsonProperty("projectImagePath")
	public void setProjectImagePath(String projectImagePath) {
		this.projectImagePath = projectImagePath;
	}

	/**
	 * 
	 * @return The projectDescription
	 */
	@JsonProperty("projectDescription")
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * 
	 * @param projectDescription
	 *            The projectDescription
	 */
	@JsonProperty("projectDescription")
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	/**
	 * 
	 * @return The status
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The startDate
	 */
	@JsonProperty("startDate")
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @param startDate
	 *            The startDate
	 */
	@JsonProperty("startDate")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return The endDate
	 */
	@JsonProperty("endDate")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * @param endDate
	 *            The endDate
	 */
	@JsonProperty("endDate")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@JsonProperty("projectId")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("projectId")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonProperty("unitOfMeasurement")
	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	@JsonProperty("unitOfMeasurement")
	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

}