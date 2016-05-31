package com.common.framework.db;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class RedisManager implements Serializable {
	private static final long serialVersionUID = -1776443716138972508L;
	private static int SECONDS = 300;
	private JedisSentinelPool jedisPool;

	public Long expireKey(String key, int seconds) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.expire(key, seconds);
			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public String saveString(String key, String value) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			String str = jedis.set(key, value);
			return str;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public String saveStringBySeconds(String key, String value, int seconds) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			String str = jedis.setex(key, seconds, value);
			
			return str;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public String saveStringBySeconds(String key, String value) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			String str = jedis.setex(key, SECONDS, value);
			return str;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public String getStringValueByKey(String key) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			String str = jedis.get(key);

			return str;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public boolean exists(String key) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			boolean bool = jedis.exists(key).booleanValue();

			return bool;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return false;
	}

	public Long delete(String key) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.del(key);

			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public String saveMap(String key, Map<String, String> map) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			String str = jedis.hmset(key, map);

			return str;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Long saveHash(String key, String field, String value) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.hset(key, field, value);

			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public List<String> getValuesFromMapByStoreKeyAndMapKey(String storeKey,
			String[] mapKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			List localList = jedis.hmget(storeKey, mapKey);

			return localList;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Long getLengthFromMapByStoreKey(String storeKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.hlen(storeKey);

			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Set<String> getMapKeyFromMapByStoreKey(String storeKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Set localSet = jedis.hkeys(storeKey);

			return localSet;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public List<String> getMapValueFromMapByStoreKey(String storeKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			List localList = jedis.hvals(storeKey);

			return localList;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Long saveList(String key, List<String> list) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long result = null;
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				result = jedis
						.lpush(key, new String[] { (String) iter.next() });
			}
			Long localLong1 = result;

			return localLong1;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Long getLengthFromListByStoreKey(String storeKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.llen(storeKey);

			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public List<String> getAllValuesFromListByStoreKey(String storeKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			List localList = jedis.lrange(storeKey, 0L, -1L);

			return localList;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public List<String> getValuesFromListByStoreKey(String storeKey, int start,
			int end) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			List localList = jedis.lrange(storeKey, start, end);

			return localList;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Long deleteFromListByByStoreKeyAndValue(String storeKey, String value) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.lrem(storeKey, 0L, value);

			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Long saveSet(String key, Set<String> set) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long result = null;
			Iterator iter = set.iterator();
			while (iter.hasNext()) {
				result = jedis.sadd(key, new String[] { (String) iter.next() });
			}
			Long localLong1 = result;

			return localLong1;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Long getLengthFromSetByStoreKey(String storeKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.scard(storeKey);

			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public Set<String> getAllValuesFromSetByStoreKey(String storeKey) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Set localSet = jedis.smembers(storeKey);

			return localSet;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public boolean isSetValue(String storeKey, String value) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			boolean bool = jedis.sismember(storeKey, value).booleanValue();

			return bool;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return false;
	}

	public Long deleteFromSetByStoreKeyAndValue(String storeKey, String value) {
		Jedis jedis = this.jedisPool.getResource();
		try {
			Long localLong = jedis.srem(storeKey, new String[] { value });

			return localLong;
		} catch (Exception e) {
		} finally {
			this.jedisPool.returnResourceObject(jedis);
		}
		return null;
	}

	public JedisSentinelPool getJedisPool() {
		return this.jedisPool;
	}

	public void setJedisPool(JedisSentinelPool jedisPool) {
		this.jedisPool = jedisPool;
	}
}