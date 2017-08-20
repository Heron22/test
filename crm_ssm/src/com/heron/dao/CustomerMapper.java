package com.heron.dao;

import java.util.List;
import com.heron.po.Customer;
import com.heron.po.QueryVo;


/**
* @Project: crm_ssm
* @Copyright: 2017-2027,2017 www.heron.com  All rights reserved
* @version: create time：2017年8月4日 下午6:38:18
* @author: Heron
* @description: 
*/
public interface CustomerMapper {
	
	public List<Customer> queryPageByVo(QueryVo vo);
	
	public Integer queryTotalCount(QueryVo vo);
	
	public Customer findById(String id);
	
	public void updateCustomer(Customer customer);
	
	public void deleteById(String id);
	
}
