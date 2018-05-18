package com.gre.sys.modules.test.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.gre.api.modules.test.ITest;
@Service
@Component
public class TestImpl implements ITest{

	@Override
	public String hello(String name) {
		return "hello:"+name;
	}

}
