package com.jwt.Test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.Test.entiites.User;
import com.jwt.Test.entiites.UserInfo;
import com.jwt.Test.repositories.UserInfoRepository;
import com.jwt.Test.repositories.UserRepository;

@Service
public class UserInfoService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserInfoRepository infoRepo;
	
	public UserInfo saveInto(UserInfo info) {
		Integer id=info.getUser().getId();
		
		User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
		
		
		info.setUser(user);
		
		return infoRepo.save(info);
	}

}
