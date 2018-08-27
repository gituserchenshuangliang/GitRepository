package com.csl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.csl.dao.UsersMapper;
import com.csl.entity.Users;
import com.csl.entity.UsersExample;
import com.csl.inter.UsersInter;
@Service
public class UsersMapperImpl implements UsersInter {
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public long countByExample(UsersExample example) {
		return usersMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(UsersExample example) {
		return usersMapper.deleteByExample(example);
	}

	@Override
	public int insert(Users record) {
		return usersMapper.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		return usersMapper.insertSelective(record);
	}

	@Override
	public List<Users> selectByExample(UsersExample example) {
		return usersMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Users record, UsersExample example) {
		return usersMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Users record, UsersExample example) {
		return usersMapper.updateByExample(record, example);
	}

}
