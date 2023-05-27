package com.nostratech.store.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.nostratech.store.domain.Author;
import com.nostratech.store.dto.AuthorQueryDTO;
import com.nostratech.store.repository.AuthorRepository;

@ApplicationScoped
public class AuthorRepositoryImpl implements AuthorRepository{

	private EntityManager entityManager;
	
	

	public AuthorRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(Author author) {
		entityManager.persist(author);
	}

	@Override
	public Optional<Author> findById(Long id) {
		Author author = entityManager.createQuery("SELECT a FROM Author a WHERE a.id = ?1", Author.class).setParameter(1, id)
				.getSingleResult();		
		return Optional.of(author);
	}

	@Override
	public List<AuthorQueryDTO> findAuthorsByBookId(List<Long> idList) {
		List<AuthorQueryDTO> query= entityManager.createQuery("SELECT new com.nostratech.store.dto.AuthorQueryDTO("
				+ "b.id, ba.id, ba.name) "
				+ "FROM Book b "
				+ "JOIN b.authors ba "
				+ "WHERE b.id IN ?1", AuthorQueryDTO.class).setParameter(1, idList).getResultList();
		return query;
	}

}
