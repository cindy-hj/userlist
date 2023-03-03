package com.example.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.vo.UserEntity;

@Mapper
public interface IUserDAO {
	public List<UserEntity> listUser();
	public int insertUser(UserEntity userEntity);
	public int updateUser(UserEntity userEntity);
	public int deleteUser(UserEntity userEntity);
}
