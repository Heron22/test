package com.heron.dao;

import java.util.List;

import com.heron.po.BaseDict;

/**
* @Project: crm_ssm
* @Copyright: 2017-2027,2017 www.heron.com  All rights reserved
* @version create time：2017年8月4日 下午8:22:27
* @author Heron
* @description
*/
public interface DictMapper {
	
	public List<BaseDict> findByTypeCode(String code);
}
