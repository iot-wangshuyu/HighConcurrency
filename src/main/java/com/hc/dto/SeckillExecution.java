package com.hc.dto;

import com.hc.entity.SuccessKilled;

//��ɱ�ɹ�ִ�к�Ľ��
public class SeckillExecution {
	
	private long seckillId;
	//��ɱ���״̬
	private int state;
	//״̬��ʾ
	private String stateInfo;
	//��ɱ�ɹ�����
	private SuccessKilled successKilled;
	
	//�ɹ�
	public SeckillExecution(long seckillId, int state, String stateInfo, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
		this.successKilled = successKilled;
	}
    //ʧ��
	public SeckillExecution(long seckillId, int state, String stateInfo) {
		super();
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	
	
	
	
	

}
