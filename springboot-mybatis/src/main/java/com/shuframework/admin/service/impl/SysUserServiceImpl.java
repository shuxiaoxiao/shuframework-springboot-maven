package com.shuframework.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuframework.admin.dao.SysUserMapper;
import com.shuframework.admin.model.SysUser;
import com.shuframework.admin.service.SysUserService;
import com.shuframework.core.AbstractService;
import com.shuframework.core.BaseMapper;

@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
	
	@Autowired
//	@Qualifier(value = "sysUserMapper")
	private SysUserMapper sysUserMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysUser> baseMapper) {
		super.setBaseMapper(baseMapper);
	}


	@Override
	@Transactional
	public int deleteById(String ids) {
		String[] idsStr = ids.split(",");
		if (idsStr.length > 0) {
			for (String id : idsStr) {
				sysUserMapper.deleteById(Integer.parseInt(id));
			}
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public SysUser login(String username, String password) {
		return sysUserMapper.login(username, password);
	}
}
