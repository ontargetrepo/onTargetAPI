package com.ontarget.request.bean;

import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "name", "description", "userId", "assignedMenuList" })
public class AddMenuProfileRequest {
	@NotEmpty
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@NotNull
	@JsonProperty("userId")
	private Integer userId;
	@NotNull
	@Valid
	@JsonProperty("assignedMenuList")
	private List<Integer> assignedMenuList;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty("assignedMenuList")
	public List<Integer> getAssignedMenuList() {
		return assignedMenuList;
	}

	@JsonProperty("assignedMenuList")
	public void setAssignedMenuList(List<Integer> assignedMenuList) {
		this.assignedMenuList = assignedMenuList;
	}

}
