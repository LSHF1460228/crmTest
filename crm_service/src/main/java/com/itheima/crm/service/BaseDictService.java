package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictService {
	/**
	 * 根据类型查询客户所属的行业 001 级别 006 客户来源 002
	 * @param typeCode
	 * @return
	 */
	public List<BaseDict> getBaseDictList(String typeCode);
}
