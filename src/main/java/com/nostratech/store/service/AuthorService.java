package com.nostratech.store.service;

import java.util.List;
import java.util.Map;

import com.nostratech.store.domain.Author;


public interface AuthorService {

	public void createAuthor(AuthorCreateRequestDTO dto);
	
	public AuthorResponseDTO findAuthorkById(Long id);
	
	public Author findById(Long id);
	
	public Map<Long, List<String>> findAuthorMaps(List<Long> bookIdList);

}
