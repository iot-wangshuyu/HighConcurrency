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
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
	
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
	* @param offset
	* @param limit
	* @return List<Seckill>
	* java 没有保存形参的记录，queryAll(int offet,int limit)  -》queryAll(arg0,arg1)
	*/
	List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);

}
