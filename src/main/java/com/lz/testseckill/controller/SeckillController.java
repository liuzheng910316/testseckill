package com.lz.testseckill.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/es/add")
	public void addToEs(@RequestParam (name="id") Integer id,
			HttpServletResponse response) throws Exception{
		String result = seckillService.addToEs(seckillService.getById(id));
		response.getWriter().println(result);
	}
	
	@RequestMapping("/es/get/{id}")
	public void searchByIdFromEs(@PathVariable Integer id,
			HttpServletResponse response) throws Exception{
		String info = seckillService.searchByIdFromEs(id);
		response.getWriter().println(info);
	}
	
	@RequestMapping("/get/{id}")
	public ModelAndView getById(@PathVariable Integer id) throws Exception{
		Seckill seckill = seckillService.getById(id);
		ModelAndView view = new ModelAndView();
		view.addObject("seckill",seckill);
		view.setViewName("seckill");
		return view;
	}
	
	@RequestMapping("/get2/{id}")
	public String get2ById(@PathVariable Integer id,
			Model model) throws Exception{
		Seckill seckill = seckillService.getById(id);
		model.addAttribute("seckill",seckill);
		return "seckill";
	}
	
	@RequestMapping("/webtest")
	public String testDisplay(){
		return "test";
	}
}
