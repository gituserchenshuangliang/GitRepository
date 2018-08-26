package csl.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csl.demo.dao.MemoMapper;

@Service
public class MemoService {
	@Autowired
	private MemoMapper memoMapper;
	
	public int addMemo(List<Object> maps){
		return memoMapper.addMemo(maps);
	}
	
	public int delMemo(String[] maps){
		return memoMapper.delMemo(maps);
	}
	
	public List<HashMap<String, Object>> queryMemo(String[] maps){
		return memoMapper.queryMemo(maps);
	}
	
	public int updateMemo(List<Object> maps){
		return memoMapper.updateMemo(maps);
	}
}
