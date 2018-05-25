package com.gre.gateway.modules.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gre.api.modules.test.ITest;
import com.gre.api.utils.UtilSpring;

@RestController
@RequestMapping("/test/")
public class TestController {
	@Reference(check=false)
	ITest test;
	@RequestMapping("test")
	public String test(String name){
		UtilSpring.getObject("userService");
		return test.hello(name);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String path="d://excels";//文件夹路径
		File paths=new File(path);
		File[] excels=paths.listFiles();//获取文件夹下的所有文件
		List<List<String>> list_outer=new ArrayList<List<String>>();//外层list
		List<String> list_inner=new ArrayList<String>();
		long size = 50*1024*1024;//50M，作为分割准则
		long mySize=0;//我的文件大小
		for (File file : excels) {
			mySize+=file.length();
			if(mySize <= size){//如果不超过50M,在里层List中加入文件路径
				list_inner.add(file.getAbsolutePath());
			}else{//超过50M
				list_outer.add(list_inner);
				list_inner.clear();//此处可能指向同一个对象，inner清楚掉，outer里边的元素也可能受影响。
				list_inner.add(file.getAbsolutePath());
				mySize=file.length();
			}
		}
		//组装完对象以后，就可以两层循环插入了
		for (List<String> l : list_outer) {
			//插入一次
			//insert(l)
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
