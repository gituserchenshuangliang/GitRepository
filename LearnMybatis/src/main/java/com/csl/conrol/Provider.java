package com.csl.conrol;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Provider {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ClassPathXmlApplicationContext aca = new ClassPathXmlApplicationContext(new String[]{"config/applicationContext.xml"});
		
		aca.start();
		
		System.in.read();
	}

}
