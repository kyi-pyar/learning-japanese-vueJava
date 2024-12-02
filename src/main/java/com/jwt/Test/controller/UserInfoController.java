package com.jwt.Test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jwt.Test.entiites.UserInfo;
import com.jwt.Test.services.UserInfoService;

@RequestMapping("/info")
@RestController
public class UserInfoController {
	
	@Autowired
	private  UserInfoService userInfoService;
	
	@PostMapping("/save")
    public ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo info) {
		System.out.println("before"+ info);
		UserInfo user = userInfoService.saveInto(info);
		System.out.println("after"+ user);
        return ResponseEntity.ok(user);
    }
	
	@GetMapping("/")
	public String test() {		
		return "return from InfoConcorller";
	}

}
