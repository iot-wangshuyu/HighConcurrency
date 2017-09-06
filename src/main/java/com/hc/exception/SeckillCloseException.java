package com.hc.exception;

/**
 * @Title: SeckillCloseException.java 
 * @Package com.hc.exception 
 * @Description: 秒杀关闭异常
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
public class SeckillCloseException extends SeckillException{

	/** @Fields serialVersionUID : TODO */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SeckillCloseException(String message) {
		super(message);
	}
	
	

}
