package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

@RestController
public class SentinelTestController {

	@SentinelResource(value = "get2", blockHandler="handletest",blockHandlerClass = {HandleTest.class})
	@GetMapping(value = "get1")
	public String getTest(){
		return "没有超出限制";
		
	}
}
