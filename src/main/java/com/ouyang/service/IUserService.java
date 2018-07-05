package com.ouyang.service;

import java.util.List;

import com.ouyang.model.User;

public interface IUserService {
	
	public List<User> getAll();
	
	public int delete();

}
