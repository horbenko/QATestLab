package com.qatestlab.cinema.dao;

import java.util.List;

import com.qatestlab.cinema.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
