package com.hc.dao;

import org.apache.ibatis.annotations.Param;

import com.hc.entity.SuccessKilled;

/**
 * @Title: SuccessKilledDao.java 
 * @Package com.hc.dao 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月4日
 * @version V1.0   
 */
public interface SuccessKilledDao {
	
	/** 
	* @Title: insertSuccessKill 
	* @Description: 插入购买明细，可以过滤重复
	* @param seckillId
	* @param userPhone
	* @throws Exception
	* @return int
	*/
	int insertSuccessKill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone) throws Exception;
	
	
	/** 
	* @Title: queryByIdWithSeckill 
	* @Description: 根据id查询秒杀成功信息，并携带秒杀产品对象实体
	* @param seckillId
	* @param userPhone
	* @throws Exception
	* @return SuccessKilled
	*/
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone) throws Exception;
}
