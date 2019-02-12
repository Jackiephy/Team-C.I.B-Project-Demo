package com.demo.service;

import java.util.List;

import com.demo.domain.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int id);
	public User findByName(String username);
	public void add(User user);
	public void del(int id);
	public void upd(User user);

}
