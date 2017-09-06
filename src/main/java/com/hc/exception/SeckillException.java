package com.hc.exception;

/**
 * @Title: SeckillException.java 
 * @Package com.hc.exception 
 * @Description: ��ɱ�쳣
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��6��
 * @version V1.0   
 */
public class SeckillException extends RuntimeException{

	/** @Fields serialVersionUID : TODO */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SeckillException(String message) {
		super(message);
	}
	
	

}
