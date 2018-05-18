package com.gre.gateway.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.gre.gateway.auth.AuthRealm;


@Configuration
@Component
public class ShiroConfiguration {
	@Bean
	public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager  securityManager){
		ShiroFilterFactoryBean bean =new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setLoginUrl("/toLogin");
		bean.setSuccessUrl("/welcome");
		bean.setUnauthorizedUrl("/403");
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/easyui/**", "anon");
		filterChainDefinitionMap.put("/sys/**", "anon");
		filterChainDefinitionMap.put("/test/**", "anon");
		filterChainDefinitionMap.put("/seat/submit", "anon");
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/log/**", "anon");
		filterChainDefinitionMap.put("/bootstrap/**", "anon");
		filterChainDefinitionMap.put("/extra/**", "anon");
		filterChainDefinitionMap.put("/toRegister", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/register", "anon");
		filterChainDefinitionMap.put("/toLogin", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/add", "perms[权限添加]");
        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
	}
	
	@Bean
	public AuthRealm getRealm(){
		return new AuthRealm();
	}
	
	@Bean
	public org.apache.shiro.mgt.SecurityManager getSecurityManager(){
		DefaultWebSecurityManager manager =new DefaultWebSecurityManager();
		manager.setRealm(getRealm());
		return manager;
	}
	@Bean
	@Primary
	public SessionDAO getSessionDao(){
		SessionDAO sessionDAO =new EnterpriseCacheSessionDAO();
		return sessionDAO;
	}
}
