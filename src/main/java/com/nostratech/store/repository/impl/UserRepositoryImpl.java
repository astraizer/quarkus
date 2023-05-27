package com.nostratech.store.repository.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.nostratech.store.domain.User;
import com.nostratech.store.repository.UserRepository;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {
	
	private final EntityManager entityManager;
	
	

	public UserRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}



	@Transactional
	@Override
	public void save(User user) {
		entityManager.persist(user);
		
	}

}
