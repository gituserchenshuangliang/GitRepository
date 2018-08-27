package com.csl.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

public class ActionResult {
	public static void returnString(Object obj){
		try {
		HttpServletResponse response = ServletActionContext.getResponse();
		
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String jsonStr = JSON.toJSONString(obj);
		
		out.print(jsonStr);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
