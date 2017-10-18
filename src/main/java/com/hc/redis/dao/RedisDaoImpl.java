package com.hc.redis.dao;

import java.util.List;
import java.util.Map;

import com.hc.utils.RedisUtil;
import com.hc.utils.SerializeUtil;

import redis.clients.jedis.Jedis;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class RedisDaoImpl implements RedisDao {
	private static final String VIRTUAL_COURSE_PREX = "lc_vc_";

	private RedisUtil redisUtil = new RedisUtil();

	/**
	 * 得到Key
	 * 
	 * @param key
	 * @return
	 */
	public String buildKey(String key) {
		return VIRTUAL_COURSE_PREX + key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shuyu.cache.RedisDao#setString(java.lang.String, int,
	 * java.lang.String)
	 */
	public void setString(String key, int seconds, String value) {
		Jedis jedis = redisUtil.getJedis();
		try {
			jedis.setex(buildKey(key), seconds, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shuyu.cache.RedisDao#exist(java.lang.String)
	 */
	public boolean exist(String key) {
		Jedis jedis = redisUtil.getJedis();
		String bKey = buildKey(key);
		try {
			if (jedis == null || !jedis.exists(bKey)) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return true;
	}

	/**
	 * 向缓存中设置对象
	 * 
	 * @param key
	 * @param param
	 */
	public <T> boolean setString(String key, String param) {

		Jedis jedis = redisUtil.getJedis();
		String bKey = buildKey(key);
		String set = null;
		try {
			set = jedis.set(bKey.getBytes(), SerializeUtil.serialize(param));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		if (!set.isEmpty() && ("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获取String值
	 * 
	 * @param key
	 * @return String
	 */
	public String getString(String key) {
		Jedis jedis = redisUtil.getJedis();
		String bKey = buildKey(key);
		String retru = null;
		try {
			if (jedis == null || !jedis.exists(bKey)) {
				return null;
			}
			byte[] in = jedis.get(bKey.getBytes());
			retru = SerializeUtil.unserialize(in).toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}

		return retru;

	}

	/**
	 * 向缓存中设置对象
	 * 
	 * @param key
	 * @param bean
	 */
	public <T> boolean setBean(String key, Object bean) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		String set = null;
		try {
			set = jedis.set(bKey.getBytes(), SerializeUtil.serialize(bean));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		if (!set.isEmpty() && ("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 根据key 获取对象
	 * 
	 * @param key
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public <T> T getBean(String key) {
		Jedis jedis = redisUtil.getJedis();
		String bKey = buildKey(key);
		T bean = null;
		try {
			if (jedis == null || !jedis.exists(bKey.getBytes())) {
				return null;
			}
			byte[] in = jedis.get(bKey.getBytes());
			bean = (T) SerializeUtil.unserialize(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return bean;

	}

	/**
	 * 设置 list
	 * 
	 * @param key
	 * @param list
	 */

	public <T> boolean setList(String key, List<T> list) {
		Jedis jedis = redisUtil.getJedis();
		String bKey = buildKey(key);
		String set = null;
		try {
			set = jedis.set(bKey.getBytes(), SerializeUtil.serialize(list));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		if (!set.isEmpty() && ("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获取list
	 * 
	 * @param key
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(String key) {
		Jedis jedis = redisUtil.getJedis();
		String bKey = buildKey(key);
		List<T> list = null;
		try {
			if (jedis == null || !jedis.exists(bKey.getBytes())) {
				return null;
			}
			byte[] in = jedis.get(bKey.getBytes());
			list = (List<T>) SerializeUtil.unserialize(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return list;

	}

	/**
	 * 设置 map
	 * 
	 * @param <T>
	 * @param key
	 */
	public <T> boolean setMap(String key, Map<String, T> map) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		String set = null;
		try {
			set = jedis.set(bKey.getBytes(), SerializeUtil.serialize(map));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		if (!set.isEmpty() && ("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获取Map
	 * 
	 * @param key
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	public <T> Map<String, T> getMap(String key) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		Map<String, T> map = null;
		try {
			if (jedis == null || !jedis.exists(bKey.getBytes())) {
				return null;
			}
			byte[] in = jedis.get(bKey.getBytes());
			map = (Map<String, T>) SerializeUtil.unserialize(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return map;
	}

	@Override
	public boolean del(String key) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		Long del = (long) 0;
		try {
			if (jedis == null || !jedis.exists(bKey.getBytes())) {
				return false;
			}
			del = jedis.del(bKey.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		if (del > 0) {
			return true;
		}
		return false;
	}

	@Override
	public <T> boolean SetInteger(String key, Integer num) {
		Jedis jedis = redisUtil.getJedis();
		String bKey = buildKey(key);
		String set = null;
		try {
			set = jedis.set(bKey, String.valueOf(num));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		if (!set.isEmpty() && ("OK").equals(set)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Integer getSetInteger(String key, Integer num) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		String set = null;
		try {
			set = jedis.getSet(bKey, String.valueOf(num));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return Integer.valueOf(set);
	}

	@Override
	public Integer getInteger(String key) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		String set = null;
		try {
			if (jedis == null || !jedis.exists(bKey)) {
				return null;
			}
			set = jedis.get(bKey);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return Integer.valueOf(set);
	}

	@Override
	public <T> boolean setHash(String key, Map<String, String> map) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		String hmset = null;
		try {
			hmset = jedis.hmset(bKey, map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		if (!hmset.isEmpty() && ("OK").equals(hmset)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, String> getAllHash(String key) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		Map<String, String> map = null;
		try {
			if (jedis == null || !jedis.exists(bKey)) {
				return null;
			}
			map = jedis.hgetAll(bKey);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return map;
	}

	@Override
	public List<String> getHashm(String key, String... fields) {
		String bKey = buildKey(key);
		Jedis jedis = redisUtil.getJedis();
		List<String> list = null;
		try {
			if (jedis == null || !jedis.exists(bKey)) {
				return null;
			}
			list = jedis.hmget(bKey, fields);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hc.redis.dao.RedisDao#login(java.lang.String, int)
	 */
	@Override
	public String login(String userId, int second) {
		Jedis jedis = redisUtil.getJedis();
		String token = buildKey(userId);
		try {
			if (jedis == null || !jedis.exists(token)) {
				// 定义key和value的值
				jedis.setex(buildKey(token), second, userId);
			} else {
				jedis.expire(token, second);
			}
		} catch (Exception e) {
			token = null;
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}

		return token;
	}

	@Override
	public Boolean validate(String token) {
		Jedis jedis = redisUtil.getJedis();
		boolean flag = false;
		try {
			if (jedis == null || !jedis.exists(token)) {
				flag = false;
			} else {
				jedis.expire(token, 30 * 24 * 60 * 60);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return flag;

	}

	@Override
	public void logout(String token) {
		Jedis jedis = redisUtil.getJedis();
		try {
			if (jedis != null && jedis.exists(token)) {
				jedis.del(token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}

	}

	@Override
	public String getUserId(String token) {
		Jedis jedis = redisUtil.getJedis();
		String userId = null;
		try {
			if (jedis != null && jedis.exists(token)) {
				userId = jedis.get(token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisUtil.returnResource(jedis);
		}
		return userId;
	}

}
