package com.hc.dao;

import org.apache.ibatis.annotations.Param;

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
	* @throws Exception
	* @return int
	*/
	int insertSuccessKill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone) throws Exception;
	
	
	/** 
	* @Title: queryByIdWithSeckill 
	* @Description: ����id��ѯ��ɱ�ɹ���Ϣ����Я����ɱ��Ʒ����ʵ��
	* @param seckillId
	* @throws Exception
	* @return SuccessKilled
	*/
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone) throws Exception;
}
