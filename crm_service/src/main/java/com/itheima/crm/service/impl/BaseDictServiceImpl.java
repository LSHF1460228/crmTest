package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper mapper;
	@Override
	public List<BaseDict> getBaseDictList(String typeCode) {
		//1.注入mapper
		//2.调用方法
		//3.返回
		return mapper.getBaseDictList(typeCode);
	}

}
