package com.shuframework.admin.service;

import com.shuframework.admin.model.SysUser;
import com.shuframework.core.BaseService;

public interface SysUserService extends BaseService<SysUser> {

	/**
	 * 登录
	 * @param loginname 用户名
	 * @param password 密码
	 * @return
	 */
	public SysUser login(String loginname, String password);
}
