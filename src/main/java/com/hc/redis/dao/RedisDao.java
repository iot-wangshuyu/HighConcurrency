package com.hc.redis.dao;

import java.util.List;
import java.util.Map;



public interface RedisDao {

	public void setString(String key, int seconds, String value);

	public boolean exist(String key);

	/**
	 * �򻺴������ö���
	 * @param key
	 * @param param
	 */
	public <T> boolean setString(String key, String param);

	/**
	 * ��ȡStringֵ
	 * @param key
	 * @return String
	 */
	public String getString(String key);

	/**
	 * �򻺴������ö���
	 * @param key
	 * @param bean
	 */
	public <T> boolean setBean(String key, Object bean);

	/**
	 * ����key ��ȡ����
	 * @param key
	 * @return T
	 */
	public <T> T getBean(String key);

	/**
	 * ���� list
	 * @param key
	 * @param list
	 */
	public <T> boolean setList(String key, List<T> list);

	/**
	 * ��ȡlist
	 * @param key
	 * @return list
	 */
	public <T> List<T> getList(String key);

	/**
	 * ���� map
	 * @param key
	 * @param map
	 */
	public <T> boolean setMap(String key, Map<String, T> map);

	/**
	 * ��ȡlist
	 * @param key
	 * @return Map
	 */
	public <T> Map<String, T> getMap(String key);
	
	/**
	 * @param key
	 * @return
	 */
	public boolean del(String key);
//�����л��洢	
	/**
	 * @param key
	 * @param num
	 * @return
	 */
	public <T> boolean SetInteger(String key,Integer num);
	
	/**
	 * @param key
	 * @return
	 */
	public Integer getSetInteger(String key,Integer num);
	
	/**
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key);
	
	
	/**
	 * �����л��洢
	 * @param key
	 * @param map
	 * @return
	 */
	public <T> boolean setHash(String key, Map<String, String> map);
	
	/**
	 * @param key
	 * @return
	 */
	public  Map<String, String> getAllHash(String key);
	
	/**
	 * @param key
	 * @param fields
	 * @return
	 */
	public List<String> getHashm(String key,String... fields);

}
