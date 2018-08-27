package com.csl.conrol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.csl.dao.impl.LearnPlanImpl;
import com.csl.entity.LearnPlan;
import com.csl.util.RedisCacheUtil;
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class RPCTest extends AbstractTestNGSpringContextTests{
	@Autowired(required=true)
	private LearnPlanImpl learnPlanImpl;
	@Autowired
	private RedisCacheUtil redisCacheUtil;
	@Test
	public void show(){
		learnPlanImpl.findPlanById("fc13426d-7f05-499f-8873-5572a16d45be");
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
		learnPlanImpl.listPlan(map);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void show4(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", "2");
		map.put("limit", "11");
		String key = "plan_condition"+JSON.toJSONString(map);
		List<LearnPlan> p = (List<LearnPlan>) redisCacheUtil.getValueOfObject(key);
		System.out.println(p);
	}
	
	@Test
	public void show5(){
		redisCacheUtil.delete("plan_fc13426d-7f05-499f-8873-5572a16d45be_sign");
	} 
}
