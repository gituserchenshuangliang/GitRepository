package com.csl.rpc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.csl.entity.LearnPlan;
import com.csl.inter.LearnPlanInter;
import com.csl.util.RedisCacheUtil;
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RPCTest extends AbstractTestNGSpringContextTests{
	@Autowired
	private LearnPlanInter plan;
	@Autowired
	private RedisCacheUtil redisCacheUtil;
	@Test
	public void show(){
		plan.findPlanById("fc13426d-7f05-499f-8873-5572a16d45be");
	}
	
	@Test
	public void show2(){
		LearnPlan p = (LearnPlan) redisCacheUtil.getValueOfObject("plan_fc13426d-7f05-499f-8873-5572a16d45be");
		System.out.println(p);
	}
	
	@Test
	public void show3(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", "2");
		map.put("limit", "10");
		plan.listPlan(map);
		
		//List<LearnPlan> p = redisCacheUtil.getValueOfObject(key);
	}
	
}
