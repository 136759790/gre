package com.gre.api.utils;

import java.util.UUID;

import com.gre.api.result.Result;
import com.gre.api.result.ResultEnum;



public class UtilResult {
	public static Result success(){
		Result r=new Result();
		r.setResult_msg("操作成功");
		r.setResult_status(ResultEnum.SUCCESS.getValue());
		return r;
	}
	public static Result success(String msg){
		Result r=new Result();
		r.setResult_msg(msg);
		r.setResult_status(ResultEnum.SUCCESS.getValue());
		return r;
	}
	public static Result error(){
		Result r=new Result();
		r.setResult_msg("操作失败请联系管理员");
		r.setResult_status(ResultEnum.ERROR.getValue());
		return r;
	}
	public static Result error(String msg){
		Result r=new Result();
		r.setResult_msg(msg);
		r.setResult_status(ResultEnum.ERROR.getValue());
		return r;
	}
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
