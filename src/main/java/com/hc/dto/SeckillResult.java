package com.hc.dto;

/**
 * @Title: SeckillResult.java 
 * @Package com.hc.dto 
 * @Description: 封装Josn结果
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
public class SeckillResult<T> {
	
	private boolean success;
	private T data;
	private String error;
	
	
	public SeckillResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}


	public SeckillResult(boolean success, T data) {
		this.success = success;
		this.data = data;
		
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}
	
	
	

}
