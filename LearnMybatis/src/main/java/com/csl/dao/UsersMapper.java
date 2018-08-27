package com.csl.dao;

import com.csl.entity.Users;
import com.csl.entity.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);
}