package com.lz.testseckill.service;

import com.lz.testseckill.model.Seckill;

public interface SeckillService {

	public void add(Seckill seckill);
	public String addToEs(Seckill seckill);
	public Seckill getById(Integer id);
	public String searchByIdFromEs(Integer id);
}
