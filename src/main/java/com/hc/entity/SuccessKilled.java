package com.hc.entity;

/**
 * @Title: SuccessKilled.java 
 * @Package com.hc.entity 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��4��
 * @version V1.0   
 */
public class SuccessKilled extends BaseEntity{
	
	/** @Fields seckillId : ��ɱ��Ʒid */
	private Long seckillId;
	
	/** @Fields userPhone : �û��ֻ��� */
	private Long userPhone;
	
	/** @Fields state : ״̬ */
	private Short state;
	
	//���һ��һ��seckillʵ���Ӧ�����ɱ�ɹ���¼��
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
