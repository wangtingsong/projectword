package com.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class HandleTest {

	public static String handletest(BlockException ex){
		System.out.println("超出限制"+ex.getClass().getCanonicalName());
		return "超出限制";
		
	}
}
