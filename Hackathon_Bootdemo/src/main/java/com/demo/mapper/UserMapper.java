package com.demo.mapper;

import java.util.List;

import com.demo.domain.User;


public interface UserMapper {
	public List<User> selectAll();
	public User selectById(int id);
	public User selectByUsername(String username);
	public void insert(User user);
	public void delete(int id);
	public void update(User user);
	

}
