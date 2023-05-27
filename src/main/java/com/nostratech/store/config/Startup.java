package com.nostratech.store.config;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.nostratech.store.domain.User;
import com.nostratech.store.repository.UserRepository;

import io.quarkus.runtime.StartupEvent;

@Singleton
public class Startup {

//	@Inject
//	private UserRepository userRepository;

	public void loadUsers(@Observes StartupEvent evt) {
	        // reset and load all test users
	       
//	        User user = new User();
//	        user.setUsername("user1");
//	        user.setPassword("user");
//	        user.setPassword(BcryptUtil.bcryptHash("user"));
//	        userRepository.save(user);
	    }
}
