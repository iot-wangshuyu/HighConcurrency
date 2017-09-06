package com.hc.enums;

/**
 * @Title: SeckillStateEnum.java 
 * @Package com.hc.enums 
 * @Description: 使用枚举表示常量数据字段
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
public enum SeckillStateEnum {
	/** @Fields SUCCESS : TODO */
	SUCCESS(1,"秒杀成功"),
	/** @Fields END : TODO */
	END(0,"秒杀结束"),
	/** @Fields REPEAT_KILL : TODO */
	REPEAT_KILL(-1,"重复秒杀"),
	/** @Fields INNER_EROR : TODO */
	INNER_EROR(-2,"系统异常"),
	/** @Fields DATA_REWRITE : TODO */
	DATA_REWRITE(-3,"数据篡改");
	
	private int state;
	private String stateInfo;
	private SeckillStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}
	public String getStateInfo() {
		return stateInfo;
	}

	public static SeckillStateEnum stateOf(int index){
		for(SeckillStateEnum state:values() ){
			if (state.getState()==index) {
				return state;
			}
		}
		return null;
	}
	
	

}
