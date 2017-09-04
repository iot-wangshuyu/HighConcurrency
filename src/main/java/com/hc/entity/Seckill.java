package com.hc.entity;

import java.util.Date;

/**
 * @Title: Seckill.java 
 * @Package com.hc.entity 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月4日
 * @version V1.0   
 */
public class Seckill extends BaseEntity{
	
	/** @Fields seckillId : 秒杀商品id */
	private Long seckillId;
	
	/** @Fields name : 商品名称 */
	private String name;
	
	/** @Fields number : 数量 */
	private Integer number;
	
	/** @Fields startTime : 秒杀开始时间 */
	private Date startTime;
	
	/** @Fields endTime : 秒杀结束时间 */
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
