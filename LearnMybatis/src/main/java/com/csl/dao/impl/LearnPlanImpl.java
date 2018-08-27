package com.csl.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.csl.dao.LearnPlanDao;
import com.csl.entity.LearnPlan;
import com.csl.inter.LearnPlanInter;
import com.csl.util.RedisCacheUtil;
@Repository
@Service
public class LearnPlanImpl implements LearnPlanInter {
	@Autowired
	private LearnPlanDao learnPlanDao;
	@Autowired
	private RedisCacheUtil redisCacheUtil;
	@Override
	public LearnPlan findPlanById(String uuid) {
		//先查询缓存
		String key = "plan_" + uuid;
		LearnPlan plan = (LearnPlan) redisCacheUtil.getValueOfObject(key);
		String keySign = key + "_sign";
        String valueSign = redisCacheUtil.getValue(keySign);
        //第一次查询为空值
        if(plan == null){
        	//plan is blank and key is existed , return null to break
        	if(redisCacheUtil.exists(key)){
        		return null;
        	}
        	// query database put redis of cache
        	plan = learnPlanDao.findPlanById(uuid);
        	redisCacheUtil.set(key, plan);
        	
        	// set timeout of key
        	redisCacheUtil.set(keySign, "1",new Long(100)*(new Random().nextInt(10) + 1));
        }
        if(valueSign != null){
        	return plan;
        }else{
        	
        	redisCacheUtil.set(keySign,"1",new Long(100)*(new Random().nextInt(10) + 1));
        	
        	new Thread(){
        		public void run() {
        			LearnPlan p = learnPlanDao.findPlanById(uuid);
                     redisCacheUtil.set(key,p);
        		};
        	}.start();;
        }
        
		return plan;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LearnPlan> listPlan(Map<String, String> map) {
		String key = "plan_condition"+JSON.toJSONString(map);
		List<LearnPlan> list = (List<LearnPlan>) redisCacheUtil.getValueOfObject(key);
		String keySign = key+"_sign";
		String keySignValue = redisCacheUtil.getValue(keySign);
		if(list == null){
			if(redisCacheUtil.exists(key)){
				return null;
			}
			list = learnPlanDao.listPlan(map);
			redisCacheUtil.set(key, list);
			redisCacheUtil.set(keySign,"1",new Long(10000));
		}
		
		if(keySignValue != null){
			return list;
		}else{
			redisCacheUtil.set(keySign,"1",new Long(10000));;
        	new Thread(){
        		public void run() {
        			List<LearnPlan> lists = learnPlanDao.listPlan(map);
        			redisCacheUtil.set(key, lists);
        		};
        	}.start();;
		}
		return list;
	}

	@Override
	public int deletePlan(String[] uuids) {
		return learnPlanDao.deletePlan(uuids);
	}

}
