package com.hc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.hc.dao.SeckillDao;
import com.hc.dao.SuccessKilledDao;
import com.hc.dto.Exposer;
import com.hc.dto.SeckillExecution;
import com.hc.entity.Seckill;
import com.hc.entity.SuccessKilled;
import com.hc.enums.SeckillStateEnum;
import com.hc.exception.RepeatKillException;
import com.hc.exception.SeckillCloseException;
import com.hc.exception.SeckillException;
import com.hc.service.SeckillService;


/**
 * @Title: SeckillServiceImpl.java 
 * @Package com.hc.service.impl 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
//@Component所有组件
@Service
public class SeckillServiceImpl implements SeckillService {
    //注入service依赖
	@Autowired
	private SeckillDao seckilldao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	// md5混淆
	private final String slat = "laldfafda";

	@Override
	public List<Seckill> getSeckillList() {
		List<Seckill> list = new ArrayList<>();
		try {
			list = seckilldao.queryAll(0, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Seckill getById(long seckillId) {
		Seckill seckill = new Seckill();
		try {
			seckill = seckilldao.queryById(seckillId);
		} catch (Exception e) {
		}
		return seckill;
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = null;
		try {
			seckill = seckilldao.queryById(seckillId);
		} catch (Exception e) {
		}
		if (seckill == null) {
			return new Exposer(false, seckillId);

		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		// 转换特定字符串的过程
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	@Override
	@Transactional
	//使用注解控制事务方法的优点：
	//1：开发团队达成一致约定,明确标注事务方法的编程风格
	//2:保证事务方法的执行时间尽可能短，不要穿插其他的网络操作。RPC/http请求或者剥离到事务方法外部
	//3：不是所有的方法都需要事务,如只有一条修改操作，或者是只读操作不需要事务控制
	//4：
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		if (md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("输入数据异常");
		}
		// 执行秒杀业务逻辑:减库存+记录购买行为
		int updateCount = 0;
		try {
			updateCount = seckilldao.reduceNumber(seckillId, new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (updateCount <= 0) {
			// 没有更新记录，秒杀没有成功
			throw new SeckillCloseException("秒杀结束");
		} else {
			// 记录购买行为
			try {
				int insert = successKilledDao.insertSuccessKill(seckillId, userPhone);
				if (insert <= 0) {
					throw new RepeatKillException("重复秒杀");
				}
				SuccessKilled queryByIdWithSeckill = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckillExecution(seckillId,SeckillStateEnum.SUCCESS, queryByIdWithSeckill);
			} catch (SeckillCloseException e) {
				throw e;
			} catch (RepeatKillException e) {
				throw e;
			} catch (Exception e) {
				throw new SeckillException("秒杀业务异常" + e.getMessage());
			}
		}
	}

	/**
	 * md5加密
	 * 
	 * @param seckillId
	 * @return
	 */
	private String getMD5(long seckillId) {
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

}
