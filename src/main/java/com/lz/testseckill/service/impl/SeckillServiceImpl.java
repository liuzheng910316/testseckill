package com.lz.testseckill.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.lz.testseckill.dao.SeckillDao;
import com.lz.testseckill.model.Seckill;
import com.lz.testseckill.service.SeckillService;
@Service
public class SeckillServiceImpl implements SeckillService{

	@Autowired
	SeckillDao seckillDao;
	@Autowired
	RedisTemplate redisTemplate;
	Logger logger = Logger.getLogger(SeckillServiceImpl.class);
	@Override
	public void add(Seckill seckill) {
		// TODO Auto-generated method stub
		seckillDao.save(seckill);
		logger.info("插入成功");
	}

	@Override
	public Seckill getById(Integer id) {
		// TODO Auto-generated method stub
		if(redisTemplate.hasKey("seckill_"+id)){
			Map map = redisTemplate.opsForHash().entries("seckill_"+id);
			logger.info("从redis获取成功:seckill_"+id);
			return convMaptoSeckill(map);
		}
		else{
			Seckill seckill = seckillDao.findOne(id);
			if(seckill==null)
				return null;
			redisTemplate.opsForHash().putAll("seckill_"+id, convSeckilltoMap(seckill));
			logger.info("从mysql获取成功:seckill_"+id);
			return seckill;
		}
	}

	private Seckill convMaptoSeckill(Map map){
		Seckill seckill = new Seckill();
		seckill.setId((Integer)map.get("id"));
		seckill.setNum((Integer)map.get("num"));
		seckill.setPrice((Double)map.get("price"));
		seckill.setName((String)map.get("name"));
		seckill.setStartTime((String)map.get("start_time"));
		seckill.setEndTime((String)map.get("end_time"));
		return seckill;
	}
	
	private Map convSeckilltoMap(Seckill seckill){
		Map map = new HashMap();
		map.put("id", seckill.getId());
		map.put("num", seckill.getNum());
		map.put("name", seckill.getName());
		map.put("price", seckill.getPrice());
		map.put("start_time", seckill.getStartTime());
		map.put("end_time", seckill.getEndTime());
		return map;
	}
}
