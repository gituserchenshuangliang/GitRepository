package com.csl.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csl.demo.inter.DubboInterRPC;
import com.csl.demo.service.SaySomething;
@Service(value="DubboDemo")
@com.alibaba.dubbo.config.annotation.Service
public class DubboInterImpl implements DubboInterRPC{
	@Autowired
	SaySomething say;
	
	public String saySomething(String something) {
		return say.say(something);
	}

}
