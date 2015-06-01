package com.ontarget.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "registration_request")
public class RegistrationRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Long id;
	@Basic(optional = false)
	@Column(name = "registration_token", nullable = false, length = 64)
	private String registrationToken;
	@Column(name = "project_id")
	private Integer projectId;
	@Column(name = "name", length = 255)
	private String name;
	@Column(name = "first_name", length = 100)
	private String firstName;
	@Column(name = "last_name", length = 100)
	private String lastName;
	@Column(name = "email", length = 45)
	private String email;
	@Column(name = "company_name", length = 45)
	private String companyName;
	@Column(name = "phone_number", length = 45)
	private String phoneNumber;
	@Column(name = "msg", columnDefinition = "TEXT")
	private String msg;
	@Column(name = "status", length = 20)
	private String status;
	@Basic(optional = false)
	@Column(name = "ts_create", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tsCreate;
	@Column(name = "user_id")
	private Integer userId;

	public RegistrationRequest() {
	}

	public RegistrationRequest(Long id) {
		this.id = id;
	}

	public RegistrationRequest(Long id, String registrationToken, Date tsCreate) {
		this.id = id;
		this.registrationToken = registrationToken;
		this.tsCreate = tsCreate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationToken() {
		return registrationToken;
	}

	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTsCreate() {
		return tsCreate;
	}

	public void setTsCreate(Date tsCreate) {
		this.tsCreate = tsCreate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof RegistrationRequest)) {
			return false;
		}
		RegistrationRequest other = (RegistrationRequest) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.RegistrationRequest[id=" + id + "]";
	}

}
