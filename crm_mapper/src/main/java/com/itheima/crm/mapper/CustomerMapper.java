package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerMapper {
	List<Customer> getCustomList(QueryVo vo);
	
	public Integer getCount(QueryVo vo);
	
	public Customer getCustomerById(Long id);
	/**
	 * 
	 * @param customer 一定是更新后的数据 根据客户的id来更新
	 */
	public void updateCustomer(Customer customer);
}
