package com.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return usermapper.selectAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return usermapper.selectById(id);
	}
	
	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return usermapper.selectByUsername(username);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		usermapper.insert(user);
		
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		usermapper.delete(id);
		
	}

	@Override
	public void upd(User user) {
		// TODO Auto-generated method stub
		usermapper.update(user);
		
	}

	
	

}
