package com.hc.dao;

import java.sql.Date;
import java.util.List;

import com.hc.entity.Seckill;

/**
 * @Title: SeckillDao.java 
 * @Package com.hc.dao 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��4��
 * @version V1.0   
 */
public interface SeckillDao {
	
	/** 
	* @Title: reduceNumber 
	* @Description: �����
	* @param seckillId
	* @param killTime
	* @return int
	*/
	int reduceNumber(long seckillId,Date killTime);
	
	/** 
	* @Title: queryById 
	* @Description: ����id��ѯ��ɱ��Ʒ����
	* @param seckillId
	* @return Seckill
	*/
	Seckill queryById(long seckillId);
	
	/** 
	* @Title: queryAll 
	* @Description: ����ƫ������ѯ��ɱ��Ʒ�б�
	* @param offet
	* @param limit
	* @return List<Seckill>
	*/
	List<Seckill> queryAll(int offet,int limit);

}
