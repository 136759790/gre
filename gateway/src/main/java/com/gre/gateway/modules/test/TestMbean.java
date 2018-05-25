package com.gre.gateway.modules.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(objectName="com.gre.mbean:name=TestMbean",description="testMbean")
@Component
public class TestMbean {
	private Integer id;
	private String name;
	
	@ManagedOperation
	public void sayHello(){
		System.out.println("hello :"+name+"---"+id);
	}
	public Integer getId() {
		return id;
	}
	@ManagedAttribute
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@ManagedAttribute
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		Map m=new HashMap(2);
		for (int i = 0; i < 10; i++) {
			m.put(i, i);
		}
		System.out.println(m);
	}
	
	
	
	
}
