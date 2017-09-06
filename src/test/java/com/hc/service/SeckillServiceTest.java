package com.hc.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hc.dto.Exposer;
import com.hc.dto.SeckillExecution;
import com.hc.entity.Seckill;
import com.hc.exception.SeckillException;
import com.hc.utils.GsonUtil;
import com.hc.utils.Log;

import sun.util.logging.resources.logging;

/**
 * @Title: SeckillServiceTest.java 
 * @Package com.hc.service 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
//配置spring和Junit整合，Junit启动是加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	
	@Autowired
	private SeckillService seckillService;

	/**
	 * Test method for {@link com.hc.service.SeckillService#getSeckillList()}.
	 */
	@Test
	public void testGetSeckillList() {
		List<Seckill> seckillList = seckillService.getSeckillList();
		Log.d(GsonUtil.GsonString(seckillList));
	}

	/**
	 * Test method for {@link com.hc.service.SeckillService#getById(long)}.
	 */
	@Test
	public void testGetById() {
		Seckill byId = seckillService.getById(1);
		Log.d(GsonUtil.GsonString(byId));
	}

	/**
	 * Test method for {@link com.hc.service.SeckillService#exportSeckillUrl(long)}.
	 */
	@Test
	public void testExportSeckillUrl() {
		Exposer exportSeckillUrl = seckillService.exportSeckillUrl(1);
		Log.d(GsonUtil.GsonString(exportSeckillUrl));
		//{"exposed":true,"md5":"3c03639d66e5c21e782b561d9ffe30fd","seckillId":1,"now":0,"start":0,"end":0}
	}

	/**
	 * Test method for {@link com.hc.service.SeckillService#executeSeckill(long, long, java.lang.String)}.
	 */
	@Test
	public void testExecuteSeckill() {
		
		Exposer exportSeckillUrl = seckillService.exportSeckillUrl(1);
		if (exportSeckillUrl!=null) {
			String md5="3c03639d66e5c21e782b561d9ffe30fd";
			long phone=13111111112L;
			SeckillExecution executeSeckill=null;
			try {
				executeSeckill = seckillService.executeSeckill(exportSeckillUrl.getSeckillId(),phone , exportSeckillUrl.getMd5());
				Log.d(GsonUtil.GsonString(executeSeckill));
			} catch (SeckillException e) {
				Log.e(e);
			}
		}else {
			Log.d("获取秒杀地址失败");	
		}
		
		
		
	}

}
