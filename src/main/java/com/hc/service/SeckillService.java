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

public interface SeckillService {
	
	/**查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 查询单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 秒杀开启时，输出秒杀接口地址，否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5) throws SeckillException,RepeatKillException,SeckillCloseException;

}
