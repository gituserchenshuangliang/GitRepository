package com.csl.action;

import java.util.HashMap;

import com.csl.entity.Users;
import com.csl.util.ActionResult;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {
	public String show() {
		Users u = new Users();
		u.setUsername("陈双亮");
		u.setAge(29);
		u.setUserphone("182279182333");
		ActionResult.returnString(u);
		return null;
	}

	public String show2() {
		Users u = new Users();
		u.setUsername("陈双亮");
		u.setAge(29);
		u.setUserphone("182279182333");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", u);
		map.put("key", "values");
		ActionResult.returnString(map);
		return null;
	}

	public String show3() {
		
		return null;
	}
}
