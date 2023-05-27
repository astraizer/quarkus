package com.nostratech.store.repository.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.nostratech.store.domain.Book;
import com.nostratech.store.repository.BookRepository;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

	private EntityManager entityManager;

	public BookRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(Book book) {
		entityManager.persist(book);

	}

	@Override
	public Book findBookById(Long id) {
		Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.id = ?1", Book.class).setParameter(1, id)
				.getSingleResult();
		return book;
	}

}
