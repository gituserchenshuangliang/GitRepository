package csl.demo.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import csl.demo.service.MemoService;

@RestController
@RequestMapping("/memo")
public class MemoController {
	@Autowired
	private MemoService memoService;
	private List<HashMap<String, Object>> hmo = new ArrayList<HashMap<String, Object>>();
	
	@RequestMapping("/add")
	public String add(String addMemo) {
//		int j = 0;
//		List<Object> list = new ArrayList<Object>();
//		for (int i = 0; i < ja.size(); i++) {
//			list.add(ja.get(i));
//		}
//		try {
//			j = memoService.addMemo(list);
//		} catch (Exception e) {
//			return "failed !";
//		}
//		if(j > 0){
//			return "success !";
//		}
		return "failed !";
	}
	
	@RequestMapping("/query")
	public List<HashMap<String, Object>> query(String uuids){
		String[] uuid = uuids.split(",");
		hmo = memoService.queryMemo(uuid);
		return hmo;
	}
	
	@RequestMapping("/del")
	public String del(String uuids) {
		String[] uuid = uuids.split(",");
		int j = memoService.delMemo(uuid);
		if(j > 0){
			return "success !";
		}
		return "failed !";
	}
	
	@RequestMapping("/update")
	public String update(String updateMemo) {
//		List<Object> list = new ArrayList<Object>();
//		JSONArray ja = JSONArray.fromObject(updateMemo);
//		for (int i = 0; i < ja.size(); i++) {
//			list.add(ja.get(i));
//		}
//		int j = memoService.updateMemo(list);
//		if(j > 0){
//			return "success !";
//		}
		return "failed !";
	}
}
