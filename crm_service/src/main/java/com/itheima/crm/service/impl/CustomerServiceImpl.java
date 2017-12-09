package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper mapper;

	@Override
	public Page<Customer> getCustomList(QueryVo vo) {
		// 需要判断 page rows 是否为空 如果为空给默认值
		if (vo.getPage() == null) {
			vo.setPage(1);
		}
		if (vo.getRows() == null) {
			vo.setRows(10);
		}

		vo.setStart((vo.getPage() - 1) * vo.getRows());
		// 计算start :(page-1) * rows

		List<Customer> customList = mapper.getCustomList(vo);
		
		//封装page
		Page<Customer> pageinfo = new Page<>();
		pageinfo.setPage(vo.getPage());
		pageinfo.setRows(customList);
		pageinfo.setSize(vo.getRows());
		
		pageinfo.setTotal(mapper.getCount(vo));
		

		return pageinfo;
	}

	@Override
	public Customer getCustomerById(Long id) {
		return mapper.getCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		mapper.updateCustomer(customer);
	}

}
