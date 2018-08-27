package com.csl.demo.service;

import org.springframework.stereotype.Service;

@Service(value="say")
public class SaySomething {
	public String say(String something){
		return something;
	}
}
