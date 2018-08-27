package com.csl.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csl.demo.entity.Music;

public interface MusicRepository extends JpaRepository<Music, String>{
}
