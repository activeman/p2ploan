package com.csii.p2p.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.csii.p2p.entity.User;
import com.csii.p2p.entity.UserExample;

@Repository(value="userDao")
public interface UserDao {

	
	public List<User> selectByExample(UserExample userExample);

	
}
