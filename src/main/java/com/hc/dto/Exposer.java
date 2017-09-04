package com.hc.dto;

//暴露秒杀地址DTO
public class Exposer {
	//是否开启秒杀
	private boolean exposed;
	//一种加密措施
	private String md5;
	
	private long seckillId;
	
	//系统当前时间（毫秒）
	private long now;
	//开启时间（毫秒）
	private long start;
	//结束时间（毫秒）
	private long end;

	public Exposer(boolean exposed, String md5, long seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, long now, long start, long end) {
		this.exposed = exposed;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposed, long seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}
	
	
	
	
	
	

}
