package com.hc.redis.dao;

import java.util.List;
import java.util.Map;



public interface RedisDao {

	public void setString(String key, int seconds, String value);

	public boolean exist(String key);

	/**
	 * 向缓存中设置对象
	 * @param key
	 * @param param
	 */
	public <T> boolean setString(String key, String param);

	/**
	 * 获取String值
	 * @param key
	 * @return String
	 */
	public String getString(String key);

	/**
	 * 向缓存中设置对象
	 * @param key
	 * @param bean
	 */
	public <T> boolean setBean(String key, Object bean);

	/**
	 * 根据key 获取对象
	 * @param key
	 * @return T
	 */
	public <T> T getBean(String key);

	/**
	 * 设置 list
	 * @param key
	 * @param list
	 */
	public <T> boolean setList(String key, List<T> list);

	/**
	 * 获取list
	 * @param key
	 * @return list
	 */
	public <T> List<T> getList(String key);

	/**
	 * 设置 map
	 * @param key
	 * @param map
	 */
	public <T> boolean setMap(String key, Map<String, T> map);

	/**
	 * 获取list
	 * @param key
	 * @return Map
	 */
	public <T> Map<String, T> getMap(String key);
	
	/**
	 * @param key
	 * @return
	 */
	public boolean del(String key);
//非序列化存储	
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
	 * 非序列化存储
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
