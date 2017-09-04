package com.hc.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hc.entity.Seckill;
import com.hc.utils.GsonUtil;


/**
 * @Title: SeckillDaoTest.java 
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
public class SeckillDaoTest {
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;

	/**
	 * Test method for {@link com.hc.dao.SeckillDao#reduceNumber(long, java.sql.Date)}.
	 */
	@Test
	public void testReduceNumber() throws Exception{
		long seckillId=1;
		Date killTime=new Date();
		int reduceNumber = seckillDao.reduceNumber(seckillId, killTime);
		System.out.println(reduceNumber);
	}

	/**
	 * Test method for {@link com.hc.dao.SeckillDao#queryById(long)}.
	 */
	@Test
	public void testQueryById()  throws Exception{
		long id=1;
		Seckill queryById = seckillDao.queryById(id);
		System.out.println(GsonUtil.GsonString(queryById));
	}

	/**
	 * Test method for {@link com.hc.dao.SeckillDao#queryAll(int, int)}.
	 */
	@Test
	public void testQueryAll()  throws Exception{
		List<Seckill> queryAll = seckillDao.queryAll(0, 10);
		System.out.println(GsonUtil.GsonString(queryAll));
	}

}
