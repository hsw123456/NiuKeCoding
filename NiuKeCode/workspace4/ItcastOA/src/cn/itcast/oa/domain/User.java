package cn.itcast.oa.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User implements Serializable{

	private Long id;

	private Department department;
	private Set<Role> roles = new HashSet<Role>();

	private String loginName;// 登录名
	private String password;// 密码默认1234
	private String name;// 真实姓名
	private String gender;// 性别
	private String phoneNumber;// 电话号码
	private String email;// 邮箱
	private String description;// 描述

	/**
	 * 检测本用户是否有指定名称的权限
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasPrivilegeByName(String name) {
		// 超级管理员具有所有权限
		if (isAdmin()) {
			return true;
		}
		// 普通用户
		for (Role role : roles) {
			for (Privilege priv : role.getPrivileges()) {
				if (priv.getName().equals(name)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 检测本用户是否有指定url的权限
	 * 
	 * @param url
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privUrl) {
		// 超级管理员具有所有权限
		if (isAdmin()) {
			return true;
		}

		// 去掉后面的参数
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}

		// 去掉UI后缀
		if (privUrl.endsWith("UI")) {
			privUrl = privUrl.substring(0, privUrl.length() - 2);
		}
		
		//如果url不需要控制，则登录后就可以使用
		Collection<String> allPrivileges = (Collection<String>) ActionContext.getContext() 
										.getApplication().get("allPrivilegeUrl");
		if(!allPrivileges.contains(privUrl)){
			return true;
		}
		else{
			// 普通用户
			for (Role role : roles) {
				for (Privilege priv : role.getPrivileges()) {
					if (privUrl.equals(priv.getUrl())) {
						return true;
					}
				}
			}
			
		}

		return false;
	}

	public boolean isAdmin() {
		return "admin".equals(loginName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
