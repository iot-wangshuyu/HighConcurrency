package com.hc.service.impl;

import java.util.List;

import com.hc.dto.Exposer;
import com.hc.dto.SeckillExecution;
import com.hc.entity.Seckill;
import com.hc.exception.RepeatKillException;
import com.hc.exception.SeckillCloseException;
import com.hc.exception.SeckillException;
import com.hc.service.SeckillService;

public class SeckillServiceImpl implements SeckillService {

	@Override
	public List<Seckill> getSeckillList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seckill getById(long seckillId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		// TODO Auto-generated method stub
		return null;
	}

}
