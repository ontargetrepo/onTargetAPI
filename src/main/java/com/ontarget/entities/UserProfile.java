package com.ontarget.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_profile_id", nullable = false)
	private Integer userProfileId;
	@JoinColumn(name = "menu_profile_id", referencedColumnName = "profile_id")
	@ManyToOne()
	private Profile menuProfile;
	@JoinColumn(name = "permission_profile_id", referencedColumnName = "profile_id")
	@ManyToOne()
	private Profile permissionProfile;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne()
	private User user;

	public UserProfile() {
	}

	public UserProfile(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Integer getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Profile getMenuProfile() {
		return menuProfile;
	}

	public void setMenuProfile(Profile menuProfile) {
		this.menuProfile = menuProfile;
	}

	public Profile getPermissionProfile() {
		return permissionProfile;
	}

	public void setPermissionProfile(Profile permissionProfile) {
		this.permissionProfile = permissionProfile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userProfileId != null ? userProfileId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the profileMenuId
		// fields are
		// not set
		if (!(object instanceof UserProfile)) {
			return false;
		}
		UserProfile other = (UserProfile) object;
		if ((this.userProfileId == null && other.userProfileId != null)
				|| (this.userProfileId != null && !this.userProfileId.equals(other.userProfileId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserProfile[userProfileId=" + userProfileId + "]";
	}

}
