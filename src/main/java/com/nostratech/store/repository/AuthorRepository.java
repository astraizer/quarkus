package com.nostratech.store.repository;

import java.util.List;
import java.util.Optional;

import com.nostratech.store.domain.Author;
import com.nostratech.store.dto.AuthorQueryDTO;

public interface AuthorRepository {

	public void save(Author author);
	
	public Optional<Author> findById(Long id);
	
	public List<AuthorQueryDTO> findAuthorsByBookId(List<Long> idList);
}
