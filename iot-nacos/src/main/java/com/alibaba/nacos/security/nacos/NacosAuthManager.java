package com.alibaba.nacos.security.nacos;

import com.alibaba.nacos.auth.AuthManager;
import com.alibaba.nacos.auth.exception.AccessException;
import com.alibaba.nacos.auth.model.Permission;
import com.alibaba.nacos.auth.model.User;
import org.springframework.stereotype.Component;

@Component
public class NacosAuthManager implements AuthManager {
	private static final String TOKEN_PREFIX = "Bearer ";

	private static final String PARAM_USERNAME = "username";

	private static final String PARAM_PASSWORD = "password";

	@Override
	public User login(Object o) throws AccessException {
		return null;
	}

	@Override
	public User loginRemote(Object o) throws AccessException {
		return null;
	}

	@Override
	public void auth(Permission permission, User user) throws AccessException {

	}
}
