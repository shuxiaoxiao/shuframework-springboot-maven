package com.shuframework.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;


public abstract class AbstractService<T> implements BaseService<T> {
	private BaseMapper<T> baseMapper;

	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public int deleteById(Serializable id) {
		return baseMapper.deleteById(id);
	}
	
	@Override
	public int deleteById(Serializable[] ids) {
		return baseMapper.deleteByIds(ids);
	}
	
	@Override
	@Transactional
	public int deleteById(String ids) {
		String[] idsStr = ids.split(",");
		if (idsStr.length > 0) {
			for (String id : idsStr) {
				baseMapper.deleteById(Integer.parseInt(id));
//				baseMapper.deleteById(id);
			}
			return 1;
		} else {
			return 0;
		}
	}
	//
//	public int deleteById(Serializable[] idArr) {
//		for (Serializable serializable : idArr) {
//			baseMapper.deleteById(serializable);
//		}
//		return 1;
//	}

//	@Override
//	public int insertSelective(T record) {
//		return baseMapper.insertSelective(record);
//	}

	@Override
	public T selectById(Serializable id) {
		return baseMapper.selectById(id);
	}

	@Override
	public List<T> selectAllByCondition(Map<String, Object> map) {
		return baseMapper.selectAllByCondition(map);
	}

	@Override
	public int updateSelective(T record) {
		return baseMapper.updateSelective(record);
	}

	@Override
	public int update(T record) {
		return baseMapper.update(record);
	}

	@Override
	public int insert(T record) {
		return baseMapper.insert(record);
	}
}
