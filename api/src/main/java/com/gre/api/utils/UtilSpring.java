package com.gre.api.utils;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component
public class UtilSpring implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	public static Object getObject(String id) {
         Object object = null;
         String[] beans= applicationContext.getBeanDefinitionNames();
         System.out.println(Arrays.toString(beans));
         object = applicationContext.getBean(id);
         return object;
	}
	
}
