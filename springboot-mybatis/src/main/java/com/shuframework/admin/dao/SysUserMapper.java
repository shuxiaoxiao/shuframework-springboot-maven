package com.shuframework.admin.dao;

import com.shuframework.admin.model.SysUser;
import com.shuframework.core.BaseMapper;

public interface SysUserMapper extends BaseMapper<SysUser> {
	
	/**
	 * 检查用户名
	 * @param loginname 用户名
	 * @return
	 */
	public SysUser checkUser(String loginname);
	
	/**
	 * 登录
	 * @param loginname 用户名
	 * @param password 密码
	 * @return
	 */
	public SysUser login(String loginname, String password);
}