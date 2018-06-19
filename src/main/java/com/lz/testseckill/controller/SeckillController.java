package com.lz.testseckill.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lz.testseckill.model.Seckill;
import com.lz.testseckill.service.SeckillService;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

	@Autowired
	SeckillService seckillService;
	
	@RequestMapping("/add")
	public void add(@ModelAttribute Seckill seckill){
		seckillService.add(seckill);
	}
	
	@RequestMapping("/get/{id}")
	public void getById(@PathVariable Integer id,
			HttpServletResponse resp) throws Exception{
		Seckill seckill = seckillService.getById(id);
		resp.getWriter().println(seckill.toString());
	}
}
