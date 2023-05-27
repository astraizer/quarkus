package com.nostratech.store.repository;

import com.nostratech.store.domain.Book;

public interface BookRepository {

	public void save(Book book);
	
	public Book findBookById(Long id);
}
