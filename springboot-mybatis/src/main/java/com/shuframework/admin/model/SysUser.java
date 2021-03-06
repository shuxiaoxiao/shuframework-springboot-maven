package com.shuframework.admin.model;

import java.io.Serializable;

public class SysUser implements Serializable {

	private Long id;//
	private String name;// 名称
	private String loginname;// 登录名
	private String pwd;// 密码
	private String sex;// 性别
	private String icon;// 图标
	private String phonenum;// 手机号
	private String phonenum2;// 备用号
	private String address;// 地址
	private String states;// 用户状态
	private String deptid;// 部门id
	private java.util.Date createtime;// 入职时间
	private java.util.Date leavetime;// 离职时间
	private String usertype;// 用户类型
	private Integer sortid;// 排序号

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getPhonenum2() {
		return this.phonenum2;
	}

	public void setPhonenum2(String phonenum2) {
		this.phonenum2 = phonenum2;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStates() {
		return this.states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getLeavetime() {
		return this.leavetime;
	}

	public void setLeavetime(java.util.Date leavetime) {
		this.leavetime = leavetime;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Integer getSortid() {
		return sortid;
	}

	public void setSortid(Integer sortid) {
		this.sortid = sortid;
	}

}
