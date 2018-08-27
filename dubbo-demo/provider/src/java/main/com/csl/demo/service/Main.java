package com.csl.demo.service;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 该类是dubbo框架提供，作用是启动dubbo服务，dubbo会在启动服务时，
 * 读取classpath下一个名为dubbo.properties文件的属性值
 * 
 * @author Administrator
 * 
 */
public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("applicationContext.xml");
		cac.start();
		System.out.println("start.....");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
