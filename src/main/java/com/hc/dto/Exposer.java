package com.hc.dto;

//��¶��ɱ��ַDTO
public class Exposer {
	//�Ƿ�����ɱ
	private boolean exposed;
	//һ�ּ��ܴ�ʩ
	private String md5;
	
	private long seckillId;
	
	//ϵͳ��ǰʱ�䣨���룩
	private long now;
	//����ʱ�䣨���룩
	private long start;
	//����ʱ�䣨���룩
	private long end;

	public Exposer(boolean exposed, String md5, long seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, long now, long start, long end) {
		this.exposed = exposed;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposed, long seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}
	
	
	
	
	
	

}
