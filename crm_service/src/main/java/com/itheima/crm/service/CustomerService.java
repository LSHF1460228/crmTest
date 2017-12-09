package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;

public interface CustomerService {
	Page<Customer> getCustomList(QueryVo vo);
	public Customer getCustomerById(Long id);
	
	public void updateCustomer(Customer customer);
}
