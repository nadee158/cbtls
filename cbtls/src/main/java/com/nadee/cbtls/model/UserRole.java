package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.session.ConcurrentSessionFilter;

import com.nadee.cbtls.constant.GeneralEnumConstants.UserRoleType;


@Entity(name = "userRole")
@Table(name = "user_role", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_role_id"})})
public class UserRole implements GrantedAuthority, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id", nullable = false)
	private long userRoleId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role_type")
	private UserRoleType userRoleType;
	
	@Version
	@Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userRoleId", userRoleId);
		map.put("userRoleType", userRoleType);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	@Override
	public String getAuthority() {
		return this.userRoleType.toString();
	}

	public long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserRoleType getUserRoleType() {
		return userRoleType;
	}
	public void setUserRoleType(UserRoleType userRoleType) {
		this.userRoleType = userRoleType;
	}

	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

}
