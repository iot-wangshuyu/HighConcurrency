package com.hc.entity;

/**
 * @Title: SuccessKilled.java 
 * @Package com.hc.entity 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月4日
 * @version V1.0   
 */
public class SuccessKilled extends BaseEntity{
	
	/** @Fields seckillId : 秒杀商品id */
	private Long seckillId;
	
	/** @Fields userPhone : 用户手机号 */
	private Long userPhone;
	
	/** @Fields state : 状态 */
	private Short state;
	
	//多对一（一个seckill实体对应多个秒杀成功记录）
	private Seckill seckill;

	public Long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}
	
	
	

}
