package com.hc.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	* @throws Exception
	* @return int
	*/
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime) throws Exception;
	
	/** 
	* @Title: queryById 
	* @Description: ����id��ѯ��ɱ��Ʒ����
	* @param seckillId
	* @throws Exception
	* @return Seckill
	*/
	Seckill queryById(long seckillId)  throws Exception;
	
	/** 
	* @Title: queryAll 
	* @Description: ����ƫ������ѯ��ɱ��Ʒ�б�
	* @param offset
	* @param limit
	* @throws Exception
	* @return List<Seckill>
	* java û�б����βεļ�¼��queryAll(int offet,int limit)  -��queryAll(arg0,arg1)
	*/
	List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit) throws Exception;

}
