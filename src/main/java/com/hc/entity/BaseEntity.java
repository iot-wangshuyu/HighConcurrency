package com.hc.entity;

import java.util.Date;

/**
 * @Title: BaseEntity.java 
 * @Package com.hc.entity 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��4��
 * @version V1.0   
 */
public class BaseEntity {
	
	/** @Fields createTime : ����ʱ�� */
	private Date createTime;
	
	/** @Fields updateTime : ���һ�θ���ʱ�� */
	private Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
