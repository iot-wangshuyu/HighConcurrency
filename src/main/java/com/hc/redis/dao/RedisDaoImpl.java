package com.hc.redis.dao;

import java.util.List;
import java.util.Map;

import com.hc.utils.RedisUtil;
import com.hc.utils.SerializeUtil;



/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class RedisDaoImpl implements RedisDao{
	private  static final  String VIRTUAL_COURSE_PREX = "lc_vc_";
	
	private RedisUtil redisUtil=new RedisUtil();
	/**
	 * 得到Key
	 * @param key
	 * @return
	 */
	public String buildKey(String key) {
		return VIRTUAL_COURSE_PREX + key;
	}
	
	/* (non-Javadoc)
	 * @see com.shuyu.cache.RedisDao#setString(java.lang.String, int, java.lang.String)
	 */
	public void setString(String key, int seconds, String value) {
		try {
			// value = StringUtil.isNullOrEmpty(value) ? "" : value;
			value = (value == null) ? "" : value;
			redisUtil.getJedis().setex(buildKey(key), seconds, value);
		} catch (Exception e) {

		}

	}
	/* (non-Javadoc)
	 * @see com.shuyu.cache.RedisDao#exist(java.lang.String)
	 */
	public boolean exist(String key) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey)) {
			return false;
		}
		return true;
	}

	/**
	 * 向缓存中设置对象
	 * @param key
	 * @param param
	 */
	public <T> boolean setString(String key, String param) {
		String bKey = buildKey(key);
		String set=null;
		try {
			set = redisUtil.getJedis().set(bKey.getBytes(), SerializeUtil.serialize(param));
		} catch (Exception e) {
                e.printStackTrace();
		}
		if (!set.isEmpty()&&("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获取String值
	 * @param key
	 * @return String
	 */
	public String getString(String key) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey)) {
			return null;
		}
		byte[] in =redisUtil. getJedis().get(bKey.getBytes());
		return  SerializeUtil.unserialize(in).toString();

	}

	/**
	 * 向缓存中设置对象
	 * @param key
	 * @param bean
	 */
	public <T> boolean setBean(String key, Object bean) {
		String bKey = buildKey(key);
		String set=null;
		try {
			set =redisUtil.getJedis().set(bKey.getBytes(), SerializeUtil.serialize(bean));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!set.isEmpty()&&("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 根据key 获取对象
	 * @param key
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public <T> T getBean(String key) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey.getBytes())) {
			return null;
		}

		byte[] in =redisUtil. getJedis().get(bKey.getBytes());
		T bean = (T) SerializeUtil.unserialize(in);
		return bean;

	}

	/**
	 * 设置 list
	 * @param key
	 * @param list
	 */

	public <T> boolean setList(String key, List<T> list) {
		String bKey = buildKey(key);
		String set=null;
		try {
			set =redisUtil.getJedis().set(bKey.getBytes(), SerializeUtil.serialize(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!set.isEmpty()&&("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获取list
	 * @param key
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(String key) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey.getBytes())) {
			return null;
		}
		byte[] in = redisUtil.getJedis().get(bKey.getBytes());
		List<T> list = (List<T>) SerializeUtil.unserialize(in);
		return list;

	}

	/**
	 * 设置 map
	 * @param <T>
	 * @param key
	 */
	public <T> boolean setMap(String key, Map<String, T> map) {
		String bKey = buildKey(key);
		String set=null;
		try {
			set =redisUtil.getJedis().set(bKey.getBytes(), SerializeUtil.serialize(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!set.isEmpty()&&("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获取Map
	 * @param key
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	public <T> Map<String, T> getMap(String key) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey.getBytes())) {
			return null;
		}
		byte[] in =redisUtil. getJedis().get(bKey.getBytes());
		Map<String, T> map = (Map<String, T>) SerializeUtil.unserialize(in);
		return map;
	}
	

	@Override
	public boolean del(String key) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey.getBytes())) {
			return false;
		}
		Long del = redisUtil. getJedis().del(bKey.getBytes());
		if (del>0) {
			return true;
		}
		return false;
	}

	@Override
	public <T> boolean SetInteger(String key, Integer num) {
		String bKey = buildKey(key);
		String set=null;
		try {
			set =redisUtil.getJedis().set(bKey, String.valueOf(num));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!set.isEmpty()&&("OK").equals(set)) {
			return true;
		} else {
			return false;
		}
		

	}

	@Override
	public Integer getSetInteger(String key,Integer num) {
		String bKey = buildKey(key);
		String set=null;
		try {
			set =redisUtil.getJedis().getSet(bKey, String.valueOf(num));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.valueOf(set);
	}

	@Override
	public Integer getInteger(String key) {
		String bKey = buildKey(key);
		String set=null;
		try {
			if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey)) {
				return null;
			}
			set =redisUtil.getJedis().get(bKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.valueOf(set);
	}

	@Override
	public <T> boolean setHash(String key, Map<String, String> map) {
		String bKey = buildKey(key);
		String hmset=null;
		try {
			hmset = redisUtil.getJedis().hmset(bKey, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!hmset.isEmpty()&&("OK").equals(hmset)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, String> getAllHash(String key) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey)) {
			return null;
		}
		
		return redisUtil. getJedis().hgetAll(bKey);
	}

	@Override
	public List<String> getHashm(String key, String... fields) {
		String bKey = buildKey(key);
		if (redisUtil.getJedis() == null || !redisUtil.getJedis().exists(bKey)) {
			return null;
		}
		return redisUtil.getJedis().hmget(bKey, fields);
	}
	
	
	
	
	

}
