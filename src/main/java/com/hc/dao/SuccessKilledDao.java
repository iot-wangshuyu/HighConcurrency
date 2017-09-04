package com.hc.dao;

import com.hc.entity.SuccessKilled;

/**
 * @Title: SuccessKilledDao.java 
 * @Package com.hc.dao 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��4��
 * @version V1.0   
 */
public interface SuccessKilledDao {
	
	/** 
	* @Title: insertSuccessKill 
	* @Description: ���빺����ϸ�����Թ����ظ�
	* @param seckillId
	* @param userPhone
	* @return int
	*/
	int insertSuccessKill(long seckillId,long userPhone);
	
	
	/** 
	* @Title: queryByIdWithSeckill 
	* @Description: ����id��ѯ��ɱ�ɹ���Ϣ����Я����ɱ��Ʒ����ʵ��
	* @param seckillId
	* @return SuccessKilled
	*/
	SuccessKilled queryByIdWithSeckill(long seckillId);
}
