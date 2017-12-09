package com.itheima.crm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Constants;
import com.itheima.crm.utils.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService basedictservice;
	
	@Autowired
	private CustomerService coustomerservice;
	@RequestMapping("/customer/list")
	public String showCustomerPage(Model model,QueryVo vo) {
		//
//		try {
//			if(vo.getCustName()!=null){
//				String custname = new String(vo.getCustName().getBytes("iso8859-1"), "utf-8");
//				vo.setCustName(custname);
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		
		//调用service查询客户来源  客户级别 客户所属的行业  列表 传递给页面展示
		List<BaseDict> sourcelist = basedictservice.getBaseDictList(Constants.CON_cust_source);
		List<BaseDict> industrylist = basedictservice.getBaseDictList(Constants.CON_cust_industry);
		List<BaseDict> levellist = basedictservice.getBaseDictList(Constants.CON_cust_level);
		//传递页面
		
		model.addAttribute("fromType", sourcelist);
		model.addAttribute("industryType", industrylist);
		model.addAttribute("levelType", levellist);
		
		//根据查询的条件查询结果列表
		
		Page<Customer> page = coustomerservice.getCustomList(vo);
		
		model.addAttribute("page", page);
		
		//数据回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	
	//URL：type:"get",
	//url:"<%=basePath%>customer/edit.action",
	//data:{"id":id},//jquery 自动将json对象转成id=1&name=12312313
	//返回值：json
	
	@RequestMapping(value="/customer/edit",method=RequestMethod.GET)
	@ResponseBody
	public Customer getCustomerById(Long id){
		Customer customer = coustomerservice.getCustomerById(id);
		return customer;
		
	}
	
	//$.post("<%=basePath%>customer/update.action",$("#edit_customer_form").serialize(),function(data){
	//produces=MediaType.APPLICATION_JSON_UTF8_VALUE:指定响应的content-type为指定的格式。
	@RequestMapping(value="/customer/update",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	//@responseBody 如果修饰的返回值得类型是类 （对象） 那么默认的content-type:就是applicatioin/json;
	//如果是修饰的是String 默认返回的content-type:text/plain; 
	public String updateCustomer(Customer customer){
		coustomerservice.updateCustomer(customer);
		//"\":表示转义符  把“ 作为字符返回
		return "{\"id\":123}";
	}
	
}
