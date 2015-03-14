package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "recentId" })
public class ActivityLogRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("recentId")
	private Integer recentId;

	/**
	 * 
	 * @return The baseRequest
	 */
	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	/**
	 * 
	 * @param baseRequest
	 *            The baseRequest
	 */
	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	/**
	 * 
	 * @return The recentId
	 */
	@JsonProperty("recentId")
	public Integer getRecentId() {
		return recentId;
	}

	/**
	 * 
	 * @param recentId
	 *            The recentId
	 */
	@JsonProperty("recentId")
	public void setRecentId(Integer recentId) {
		this.recentId = recentId;
	}
}