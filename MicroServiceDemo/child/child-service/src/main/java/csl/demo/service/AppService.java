package csl.demo.service;

import java.util.ArrayList;
import java.util.List;

import csl.demo.dao.App;
public class AppService 
{
    public List<App> getInstance(){
    	List<App> list = new ArrayList<App>();
    	list.add(new App("A","A name"));
    	list.add(new App("B","B name"));
    	return list;
    }
}
