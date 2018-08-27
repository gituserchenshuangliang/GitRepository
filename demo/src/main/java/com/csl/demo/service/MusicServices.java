package com.csl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.csl.demo.dao.MusicRepository;
import com.csl.demo.entity.Music;

@Repository
public class MusicServices {
	@Autowired
	private MusicRepository musicRepository;

	public void save(Music music) {
		musicRepository.save(music);
	}

	public Page<Music> list(PageRequest Page) {
		return musicRepository.findAll(Page);
	}

	public Music findById(String id) {
		return musicRepository.findOne(id);
	}

	public void delById(String id) {
		musicRepository.delete(id);
	}
}