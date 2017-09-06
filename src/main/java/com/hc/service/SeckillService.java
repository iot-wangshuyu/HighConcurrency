package com.hc.service;
//վ��ʹ���ߵĽǶ���ƽӿ�
//�������棺������������,����,�������ͣ�return ����/�쳣��

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
 * @date Creation time: 2017��9��6��
 * @version V1.0   
 */
public interface SeckillService {
	
	/** 
	* @Title: getSeckillList 
	* @Description: ��ѯ������ɱ��¼
	* @return List<Seckill>
	*/
	List<Seckill> getSeckillList();
	/** 
	* @Title: getById 
	* @Description: ��ѯ������ɱ��¼
	* @param seckillId
	* @return Seckill
	*/
	Seckill getById(long seckillId);
	/** 
	* @Title: exportSeckillUrl 
	* @Description: ��ɱ����ʱ�������ɱ�ӿڵ�ַ���������ϵͳʱ�����ɱʱ��
	* @param seckillId
	* @return Exposer
	*/
	Exposer exportSeckillUrl(long seckillId);
	
	/** 
	* @Title: executeSeckill 
	* @Description: ִ����ɱ����
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
