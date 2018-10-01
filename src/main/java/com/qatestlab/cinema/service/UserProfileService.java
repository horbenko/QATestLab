package com.qatestlab.cinema.service;

import java.util.List;

import com.qatestlab.cinema.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
