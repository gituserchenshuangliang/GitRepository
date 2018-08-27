package com.csl.dao;

import java.util.List;
import java.util.Map;

import com.csl.entity.LearnPlan;

public interface LearnPlanDao {
	LearnPlan findPlanById(String uuid);

	List<LearnPlan> listPlan(Map<String, String> map);

	int deletePlan(String[] uuids);

	int addPlan(List<LearnPlan> list);
}
