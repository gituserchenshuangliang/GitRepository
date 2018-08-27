package com.csl.inter;

import java.util.List;
import java.util.Map;

import com.csl.entity.LearnPlan;
public interface LearnPlanInter {
	LearnPlan findPlanById(String uuid);
	List<LearnPlan> listPlan(Map<String,String> map);
	int deletePlan(String []uuids);
}
