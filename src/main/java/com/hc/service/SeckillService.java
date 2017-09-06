package com.hc.service;
//站在使用者的角度设计接口
//三个方面：方法定义粒度,参数,返回类型（return 类型/异常）

import java.util.List;

import com.hc.dto.Exposer;
import com.hc.dto.SeckillExecution;
import com.hc.entity.Seckill;
import com.hc.exception.RepeatKillException;
import com.hc.exception.SeckillCloseException;
import com.hc.exception.SeckillException;

/**
 * @Title: SeckillService.java 
 * @Package com.hc.service 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
public interface SeckillService {
	
	/** 
	* @Title: getSeckillList 
	* @Description: 查询所有秒杀记录
	* @return List<Seckill>
	*/
	List<Seckill> getSeckillList();
	/** 
	* @Title: getById 
	* @Description: 查询单个秒杀记录
	* @param seckillId
	* @return Seckill
	*/
	Seckill getById(long seckillId);
	/** 
	* @Title: exportSeckillUrl 
	* @Description: 秒杀开启时，输出秒杀接口地址，否则输出系统时间和秒杀时间
	* @param seckillId
	* @return Exposer
	*/
	Exposer exportSeckillUrl(long seckillId);
	
	/** 
	* @Title: executeSeckill 
	* @Description: 执行秒杀操作
	* @param seckillId
	* @param userPhone
	* @param md5
	* @throws SeckillException
	* @throws RepeatKillException
	* @throws SeckillCloseException
	* @return SeckillExecution
	*/
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5) throws SeckillException,RepeatKillException,SeckillCloseException;

}
