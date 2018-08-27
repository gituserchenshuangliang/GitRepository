package com.csl.conrol;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.csl.dao.LearnPlanDao;
import com.csl.entity.LearnPlan;

@RestController
@RequestMapping("/mybatis")
public class TestMVC {
	@Autowired
	private LearnPlanDao learnPlanDao;
	@RequestMapping("/show")
	public List<LearnPlan> show(String query){
		HashMap<String, String> map = new HashMap<String, String>();
		JSONObject json = JSONObject.parseObject(query);
		map.put("planner", json.getString("planner"));
		map.put("contents", json.getString("contents"));
		map.put("start", json.getString("start"));
		map.put("limit", json.getString("limit"));
		List<LearnPlan> planList = learnPlanDao.listPlan(map);
		return planList;
	}
}
