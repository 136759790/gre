package com.gre.gateway.modules.test;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName="com.gre.mbean:name=TestMbean",description="testMbean")
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
	
	
	
	
}
