package com.hc.entity;

import java.sql.Date;

/**
 * @Title: Seckill.java 
 * @Package com.hc.entity 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��4��
 * @version V1.0   
 */
public class Seckill extends BaseEntity{
	
	/** @Fields seckillId : ��ɱ��Ʒid */
	private Long seckillId;
	
	/** @Fields name : ��Ʒ���� */
	private String name;
	
	/** @Fields number : ���� */
	private Integer number;
	
	/** @Fields startTime : ��ɱ��ʼʱ�� */
	private Date startTime;
	
	/** @Fields endTime : ��ɱ����ʱ�� */
	private Date endTime;

	public Long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
	

}
