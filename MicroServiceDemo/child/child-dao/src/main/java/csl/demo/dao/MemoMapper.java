package csl.demo.dao;

import java.util.HashMap;
import java.util.List;
public interface MemoMapper {
	int addMemo(List<Object> lists);

	List<HashMap<String, Object>> queryMemo(String[] uuid);
	
	int delMemo(String[] uuid);
	
	int updateMemo(List<Object> lists);
}
