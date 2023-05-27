package com.nostratech.store.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.BadRequestException;

import com.nostratech.store.domain.Author;
import com.nostratech.store.dto.AuthorQueryDTO;
import com.nostratech.store.repository.AuthorRepository;
import com.nostratech.store.service.AuthorCreateRequestDTO;
import com.nostratech.store.service.AuthorResponseDTO;
import com.nostratech.store.service.AuthorService;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@Override
	public void createAuthor(AuthorCreateRequestDTO dto) {
		Author author = new Author();
		author.setName(dto.name());
		authorRepository.save(author);

	}

	@Override
	public AuthorResponseDTO findAuthorkById(Long id) {
		Author author = findById(id);
		return new AuthorResponseDTO(author.getId(), author.getName());
	}

	@Override
	public Author findById(Long id) {

		return authorRepository.findById(id).orElseThrow(() -> new BadRequestException("invalid id"));
		
	}

	@Override
	public Map<Long, List<String>> findAuthorMaps(List<Long> bookIdList) {
		List<AuthorQueryDTO> queryList =  authorRepository.findAuthorsByBookId(bookIdList);
		Map<Long, List<String>> authorMap = new HashMap<>();
		List<String> authorList = null;
		for(AuthorQueryDTO q:queryList) {
			if(!authorMap.containsKey(q.bookId())) {
				authorList = new ArrayList<>();
			}else {
				authorList = authorMap.get(q.bookId());
			}
			
			authorList.add(q.authorName());
			authorMap.put(q.bookId(), authorList);
		}
		return authorMap;
	}

}
