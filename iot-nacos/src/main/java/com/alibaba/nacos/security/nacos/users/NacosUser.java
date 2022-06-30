package com.alibaba.nacos.security.nacos.users;

import com.alibaba.nacos.auth.model.User;

public class NacosUser extends User {

	private String token;

	private boolean globalAdmin = false;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isGlobalAdmin() {
		return globalAdmin;
	}

	public void setGlobalAdmin(boolean globalAdmin) {
		this.globalAdmin = globalAdmin;
	}

	@Override
	public String toString() {
		return "NacosUser{" + "token='" + token + '\'' + ", globalAdmin=" + globalAdmin + '}';
	}

}
