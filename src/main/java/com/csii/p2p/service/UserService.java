package com.csii.p2p.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csii.p2p.dao.UserDao;
import com.csii.p2p.dao.UserMapper;
import com.csii.p2p.entity.User;
import com.csii.p2p.entity.UserExample;
import com.csii.p2p.entity.UserExample.Criteria;

@Service
public class UserService {

	
	@Autowired
	private UserMapper userMapper;

	/*
	@Autowired
	private UserDao userDao;
	*/
	
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(new UserExample());
	}

	public boolean checkIfRegist(String uphone) {
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andUphoneEqualTo(uphone);
		
		List<User>ulist = userMapper.selectByExample(example);
	
		return ulist.size()>0?true:false;
	}

	public int addUser(User user) {
		
		return userMapper.insert(user);
		
	}
	
	
	
}
