package com.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class HandleTest {

	public static String handletest(BlockException ex){
		System.out.println("��������"+ex.getClass().getCanonicalName());
		return "��������";
		
	}
}
