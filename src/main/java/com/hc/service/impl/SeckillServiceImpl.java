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
 * @date Creation time: 2017��9��6��
 * @version V1.0   
 */
//@Component�������
@Service
public class SeckillServiceImpl implements SeckillService {
    //ע��service����
	@Autowired
	private SeckillDao seckilldao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	// md5����
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
		// ת���ض��ַ����Ĺ���
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	@Override
	@Transactional
	//ʹ��ע��������񷽷����ŵ㣺
	//1�������ŶӴ��һ��Լ��,��ȷ��ע���񷽷��ı�̷��
	//2:��֤���񷽷���ִ��ʱ�価���̣ܶ���Ҫ�������������������RPC/http������߰��뵽���񷽷��ⲿ
	//3���������еķ�������Ҫ����,��ֻ��һ���޸Ĳ�����������ֻ����������Ҫ�������
	//4��
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		if (md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("���������쳣");
		}
		// ִ����ɱҵ���߼�:�����+��¼������Ϊ
		int updateCount = 0;
		try {
			updateCount = seckilldao.reduceNumber(seckillId, new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (updateCount <= 0) {
			// û�и��¼�¼����ɱû�гɹ�
			throw new SeckillCloseException("��ɱ����");
		} else {
			// ��¼������Ϊ
			try {
				int insert = successKilledDao.insertSuccessKill(seckillId, userPhone);
				if (insert <= 0) {
					throw new RepeatKillException("�ظ���ɱ");
				}
				SuccessKilled queryByIdWithSeckill = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckillExecution(seckillId,SeckillStateEnum.SUCCESS, queryByIdWithSeckill);
			} catch (SeckillCloseException e) {
				throw e;
			} catch (RepeatKillException e) {
				throw e;
			} catch (Exception e) {
				throw new SeckillException("��ɱҵ���쳣" + e.getMessage());
			}
		}
	}

	/**
	 * md5����
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
