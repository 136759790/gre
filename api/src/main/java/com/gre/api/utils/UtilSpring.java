package com.gre.api.utils;

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
		applicationContext = applicationContext;
	}
	public static Object getObject(String id) {
         Object object = null;
         object = applicationContext.getBean(id);
         return object;
	}
	
}
