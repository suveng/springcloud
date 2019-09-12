package com.qw.support.currency.lock;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * description: 依赖于component注解, component注解在spring-context包下面
 * 所以抽离需要引入spring-context的依赖 以及 stringRedisTemplate
 * @author suwenguang
 * @version 1.0.0
 **/
@Component
@Slf4j
public class RedisLock {
	@Autowired
	private StringRedisTemplate redisTemplate;


	/**
	 * 方法:  lock: 加锁,设置成功则证明没有竞争,如果失败则存在竞争
	 *
	 * @author suwenguang@52tt.com
	 * @param key (类型:String )
	 * @return boolean
	 */
	public boolean lock(String key, String value, int seconds) {
		Boolean res = redisTemplate.opsForValue().setIfAbsent(key, value);
		if (ObjectUtil.isEmpty(res)) {
			return false;
		}
		if (!res) {
			log.error("redis加锁失败,key:{},value:{}", key, value);
		} else {
			log.info("redis加锁成功,key:{},value:{}", key, value);
			Boolean expire = redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
			if (ObjectUtil.isEmpty(expire)) {
				return false;
			}
			if (expire) {
				log.info("redis设置超时成功,key:{},value:{},expire:{}s", key, value, seconds);
			} else {
				log.error("redis设置超时失败,请手动清理redis过期时间,key:{},value:{}", key, value);
			}
		}
		return res;
	}

	/**
	 * 方法:  unLock:解锁操作
	 * @author suwenguang
	 *
	 * @param key (类型:String )
	 */
	public void unLock(String key) {
		redisTemplate.delete(key);
		log.info("redis解锁成功,key:{}", key);
	}
}
