package com.hc.dto;

import com.hc.entity.SuccessKilled;

//秒杀成功执行后的结果
public class SeckillExecution {
	
	private long seckillId;
	//秒杀结果状态
	private int state;
	//状态表示
	private String stateInfo;
	//秒杀成功对象
	private SuccessKilled successKilled;
	
	//成功
	public SeckillExecution(long seckillId, int state, String stateInfo, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
		this.successKilled = successKilled;
	}
    //失败
	public SeckillExecution(long seckillId, int state, String stateInfo) {
		super();
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	
	
	
	
	

}
