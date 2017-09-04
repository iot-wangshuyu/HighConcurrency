package com.hc.dao;

import java.sql.Date;
import java.util.List;

import com.hc.entity.Seckill;

/**
 * @Title: SeckillDao.java 
 * @Package com.hc.dao 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月4日
 * @version V1.0   
 */
public interface SeckillDao {
	
	/** 
	* @Title: reduceNumber 
	* @Description: 减库存
	* @param seckillId
	* @param killTime
	* @return int
	*/
	int reduceNumber(long seckillId,Date killTime);
	
	/** 
	* @Title: queryById 
	* @Description: 根据id查询秒杀商品对象
	* @param seckillId
	* @return Seckill
	*/
	Seckill queryById(long seckillId);
	
	/** 
	* @Title: queryAll 
	* @Description: 根据偏移量查询秒杀商品列表
	* @param offet
	* @param limit
	* @return List<Seckill>
	*/
	List<Seckill> queryAll(int offet,int limit);

}
