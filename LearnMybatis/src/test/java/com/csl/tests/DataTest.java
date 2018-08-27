package com.csl.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.csl.dao.LearnPlanDao;
import com.csl.dao.MusicDao;
import com.csl.entity.LearnPlan;
import com.csl.entity.Music;
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class DataTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private LearnPlanDao learnPlan;
	@Autowired
	private MusicDao musicDao;
	@Test
	public void show() throws InterruptedException{
		for (int j = 0; j < 100; j++) {
			List<LearnPlan> list = new ArrayList<LearnPlan>();
			for (int i = 0; i < 10000; i++) {
				LearnPlan p = new LearnPlan();
				list.add(p);
			}
			learnPlan.addPlan(list);
		}
	}
	@Test
	public void show2() {
		List<Music> list = new ArrayList<Music>();
		File file = new File("F:/music");
		list = listFiles(file,list);
		musicDao.addMusics(list);
	}
	
	public  List<Music> listFiles(File file,List<Music> list) {
		if (file.isDirectory()) {
			File fs[] = file.listFiles();
			for (File files : fs) {
				listFiles(files,list);
			}
		} else {
			Music m = new Music(file.getName(), file.getAbsolutePath());
			list.add(m);
		}
		return list;
	}
}
