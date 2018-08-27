package com.csl.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csl.demo.entity.Music;
import com.csl.demo.service.MusicServices;

@RestController
@RequestMapping("/music")
public class MusicController {
	@Autowired
	private MusicServices musicServices;

	@Transactional
	@RequestMapping("/save")
	public String save() {
		musicServices.save(new Music(UUID.randomUUID().toString(),"路边的野花", "邓丽君"));
		musicServices.save(new Music(UUID.randomUUID().toString(),"爱你在心口难开", "邓丽君"));
		musicServices.save(new Music(UUID.randomUUID().toString(),"月亮代表我的心", "邓丽君"));
		musicServices.save(new Music(UUID.randomUUID().toString(),"海韵", "邓丽君"));
		musicServices.save(new Music(UUID.randomUUID().toString(),"月如钩", "邓丽君"));
		return "ok !";
	}

	@RequestMapping("/list")
	public List<Music> list(Integer i) {
		PageRequest page = new PageRequest(i, 4);
		return musicServices.list(page).getContent();
	}

	@RequestMapping("/find")
	public Music findOne(String id) {
		return musicServices.findById(id);
	}

	@RequestMapping("/del")
	@Transactional
	public String del(String id) {
		musicServices.delById(id);
		return "Delete Success !";
	}
}