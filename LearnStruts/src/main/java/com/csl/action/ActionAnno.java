package com.csl.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.csl.util.ActionResult;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class ActionAnno extends ActionSupport {
	private String jsonStr;
	
	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public String show3(){
		ActionResult.returnString("使用注解 Action");;
		return null;
	}
	
	public String show4(){
		String str = ServletActionContext.getRequest().getParameter("jsonStr");
		System.out.println(str);
		ActionResult.returnString(jsonStr);;
		return null;
	}
}
