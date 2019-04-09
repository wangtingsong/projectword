package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mapper.PersonMapper;

@RestController
public class SentinelTestController {

	@Autowired
	PersonMapper personMapper;
	@SentinelResource(value = "get2", blockHandler="handletest",blockHandlerClass = {HandleTest.class})
	@GetMapping(value = "get1")
	public String getTest(){
		System.out.println("输出name:"+personMapper.getName(1));
		return "没有超出限制";
		
	}
}
