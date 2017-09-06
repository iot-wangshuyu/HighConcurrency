package com.hc.enums;

/**
 * @Title: SeckillStateEnum.java 
 * @Package com.hc.enums 
 * @Description: ʹ��ö�ٱ�ʾ���������ֶ�
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��6��
 * @version V1.0   
 */
public enum SeckillStateEnum {
	/** @Fields SUCCESS : TODO */
	SUCCESS(1,"��ɱ�ɹ�"),
	/** @Fields END : TODO */
	END(0,"��ɱ����"),
	/** @Fields REPEAT_KILL : TODO */
	REPEAT_KILL(-1,"�ظ���ɱ"),
	/** @Fields INNER_EROR : TODO */
	INNER_EROR(-2,"ϵͳ�쳣"),
	/** @Fields DATA_REWRITE : TODO */
	DATA_REWRITE(-3,"���ݴ۸�");
	
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
