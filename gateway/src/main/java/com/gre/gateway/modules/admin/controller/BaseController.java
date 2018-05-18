package com.gre.gateway.modules.admin.controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.modules.admin.user.model.UserInfoParam;
import com.gre.api.modules.admin.user.service.IUserInfoService;
import com.gre.api.result.Result;
import com.gre.api.utils.UtilResult;


@Controller
@RequestMapping("/")
public class BaseController {
	@Reference(check=false)
	IUserInfoService userinfoService;
	
	@ApiOperation("跳转到登陆页面")
	@GetMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	@ApiOperation("登陆系统")
	@PostMapping("login")
	public String login(String username,String password){
		UsernamePasswordToken token =new UsernamePasswordToken(username, password);
		SecurityUtils.getSubject().login(token);
		return "redirect:/welcome";
	}
	@ApiOperation("跳转到首页")
	@GetMapping("welcome")
	public String welcome(){
		return "welcome";
	}
	@ApiOperation("注册")
	@PostMapping("register")
	@ResponseBody
	public Result register(UserInfo userinfo){
		try {
			userinfoService.register(userinfo);
			return UtilResult.success("注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return UtilResult.error(e.getMessage());
		}
	}
	@ApiOperation("跳转到注册页面")
	@GetMapping("toRegister")
	public String toRegister(UserInfoParam param){
		return "register";
	}
}
