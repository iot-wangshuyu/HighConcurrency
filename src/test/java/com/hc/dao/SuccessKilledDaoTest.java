package com.hc.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hc.entity.SuccessKilled;
import com.hc.utils.GsonUtil;

/**
 * @Title: SuccessKilledDaoTest.java 
 * @Package com.hc.dao 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月4日
 * @version V1.0   
 */
//配置spring和Junit整合，Junit启动是加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {
	@Resource
	private SuccessKilledDao successKilledDao;

	/**
	 * Test method for {@link com.hc.dao.SuccessKilledDao#insertSuccessKill(long, long)}.
	 */
	@Test
	public void testInsertSuccessKill()  throws Exception{
		long id=2L;
		long phone=12121205710L;
		int insertSuccessKill = successKilledDao.insertSuccessKill(id, phone);
		System.out.println(insertSuccessKill);
	}

	/**
	 * Test method for {@link com.hc.dao.SuccessKilledDao#queryByIdWithSeckill(long, long)}.
	 */
	@Test
	public void testQueryByIdWithSeckill() throws Exception{
		long id=1L;
		long phone=12121205710L;
		SuccessKilled queryByIdWithSeckill = successKilledDao.queryByIdWithSeckill(id,phone);
		System.out.println(GsonUtil.GsonString(queryByIdWithSeckill));
	}

}
