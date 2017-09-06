package com.hc.exception;

/**
 * @Title: RepeatKillException.java 
 * @Package com.hc.exception 
 * @Description: 重复秒杀异常（运行时异常）
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
public class RepeatKillException extends SeckillException{
	
	/** @Fields serialVersionUID : TODO */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public RepeatKillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
