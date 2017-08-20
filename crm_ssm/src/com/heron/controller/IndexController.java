package com.heron.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heron.po.BaseDict;
import com.heron.po.Customer;
import com.heron.po.QueryVo;
import com.heron.service.CustomerService;

import cn.itcast.utils.Page;

/**
* @Project: crm_ssm
* @Copyright: 2017-2027,2017 www.heron.com  All rights reserved
* @version create time：2017年8月4日 上午10:50:26
* @author Heron
* @description 
*/
@Controller
@RequestMapping("/customer")
public class IndexController {
	@Resource
	private CustomerService  service ;
	//引入资源文件中的常量
	@Value("${customer.from.type}")
	private String source ;
	@Value("${customer.industry.type}")
	private String industryType;
	@Value("${customer.level.type}")
	private String level;
	
	@RequestMapping("/list")
	public String login(QueryVo vo,Model model ){
		List<BaseDict> sourceList = service.findByTypeCode(source);
		List<BaseDict> typeList = service.findByTypeCode(industryType);
		List<BaseDict> levelList = service.findByTypeCode(level);
		
		if(vo.getPage()==null) {
			vo.setPage(1);
		}
		
		vo.setStart((vo.getPage()-1)*vo.getSize());
		
		
		List<Customer> pageContent = service.queryPageByVo(vo);
		Integer total = service.queryTotalCount(vo);
		
		Page<Customer> page = new Page<>();
		page.setPage(vo.getPage());
		page.setRows(pageContent);
		page.setSize(vo.getSize());
		page.setTotal(total);
		
		model.addAttribute("page", page);
		
		//下拉列表
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", typeList);
		model.addAttribute("levelType", levelList);
		
		//回显查询数据
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public Customer editData(String id){
		Customer customer = service.findById(id);
		return customer;
	}
	
	@RequestMapping("/update")
	public String update(Customer customer){
		service.update(customer);
		return "customer";
	}
	
	@RequestMapping("/delete")
	public String delete(String id){
		service.deleteById(id);
		return "customer";
	}
}
