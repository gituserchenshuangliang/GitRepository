package com.csl.demo.dao;

import java.util.List;
import java.util.Map;

import com.csl.demo.entity.LearnPlan;

public interface LearnPlanDao {
	LearnPlan findPlanById(String uuid);
	List<LearnPlan> listPlan(Map<String,String> map);
	int deletePlan(String []uuids);
}
