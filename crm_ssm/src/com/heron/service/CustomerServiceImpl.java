package com.heron.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heron.dao.CustomerMapper;
import com.heron.dao.DictMapper;
import com.heron.po.BaseDict;
import com.heron.po.Customer;
import com.heron.po.QueryVo;

/**
* @Project: crm_ssm
* @Copyright: 2017-2027,2017 www.heron.com  All rights reserved
* @version create time：2017年8月4日 下午6:51:02
* @author Heron
* @description
*/
@Service
public class CustomerServiceImpl implements CustomerService {
	@Resource
	private CustomerMapper customerMapper ;
	@Resource
	private DictMapper dictMapper ;

	@Override
	public List<Customer> queryPageByVo(QueryVo vo) {
		return customerMapper.queryPageByVo(vo);
	}

	@Override
	public Integer queryTotalCount(QueryVo vo) {
		return customerMapper.queryTotalCount(vo);
	}

	@Override
	public List<BaseDict> findByTypeCode(String code) {
		return dictMapper.findByTypeCode(code);
	}

	@Override
	public Customer findById(String id) {
		return customerMapper.findById(id);
	}

	@Override
	public void update(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteById(String id) {
		customerMapper.deleteById(id);
	}

	

}
