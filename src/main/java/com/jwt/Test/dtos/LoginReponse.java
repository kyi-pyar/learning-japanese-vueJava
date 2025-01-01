package com.jwt.Test.dtos;

import com.jwt.Test.entiites.User;

public class LoginReponse {
	private String token;
	private User user;

    private long expiresIn;

    public String getToken() {
        return token;
    }

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
    

}
