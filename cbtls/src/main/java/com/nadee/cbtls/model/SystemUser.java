package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

@Entity(name = "systemUser")
@Table(name = "system_user", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class SystemUser implements UserDetails,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
	private long userId;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "user_display_name")
	private String userDisplayName;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "profile_image_url")
	private String profileImageUrl;
	
	@OneToMany(mappedBy = "systemUser", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SystemUserMobileDevice> systemUserMobileDevices;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "system_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_role_id"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<UserRole> userRoles;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "yes_no_status")
	private YesNoStatus activeStatus;
	
	@Version
	@Column(name = "version_id")
	private int versionId;
	
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("userName", userName);
		map.put("password", password);
		map.put("userDisplayName", userDisplayName);
		map.put("emailAddress", emailAddress);
		map.put("profileImageUrl", profileImageUrl);
		map.put("activeStatus", activeStatus);
		map.put("systemUserMobileDevices", systemUserMobileDevices);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.userRoles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return (this.activeStatus.getCode()==YesNoStatus.YES.getCode())?true:false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return (this.activeStatus.getCode()==YesNoStatus.YES.getCode())?true:false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return (this.activeStatus.getCode()==YesNoStatus.YES.getCode())?true:false;
	}

	@Override
	public boolean isEnabled() {
		return (this.activeStatus.getCode()==YesNoStatus.YES.getCode())?true:false;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public List<SystemUserMobileDevice> getSystemUserMobileDevices() {
		return systemUserMobileDevices;
	}

	public void setSystemUserMobileDevices(List<SystemUserMobileDevice> systemUserMobileDevices) {
		this.systemUserMobileDevices = systemUserMobileDevices;
	}
	
	

}
