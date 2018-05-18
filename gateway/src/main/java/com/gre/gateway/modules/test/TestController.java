package com.gre.gateway.modules.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gre.api.modules.test.ITest;

@RestController
@RequestMapping("/test/")
public class TestController {
	@Reference(check=false)
	ITest test;
	@RequestMapping("test")
	public String test(String name){
		return test.hello(name);
	}
}