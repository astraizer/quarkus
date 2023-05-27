package com.nostratech.store.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.nostratech.store.domain.Author;
import com.nostratech.store.domain.Book;
import com.nostratech.store.dto.BookCreateRequestDTO;
import com.nostratech.store.dto.BookResponseDTO;
import com.nostratech.store.repository.AuthorRepository;
import com.nostratech.store.repository.BookRepository;
import com.nostratech.store.service.AuthorService;
import com.nostratech.store.service.BookService;

@ApplicationScoped
public class BookServiceImpl implements BookService{
	

	private final BookRepository bookRepository;
	
	private final AuthorService authorService;
	


	public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
		super();
		this.bookRepository = bookRepository;
		this.authorService = authorService;
	}

	@Override
	public void createBook(BookCreateRequestDTO dto) {
		
		Author author = authorService.findById(dto.authorId());
		List<Author> authors = Arrays.asList(author);
		
		Book book = new Book();
		book.setTitle(dto.title());
		book.setAuthors(authors);
		book.setDescription(dto.description());
		bookRepository.save(book);
		
	}

	@Override
	public BookResponseDTO findBookById(Long id) {
		Book book = bookRepository.findBookById(id);
		Map<Long, List<String>> authorMaps = authorService.findAuthorMaps(Arrays.asList(id));
		List<Author> author =  book.getAuthors();
		BookResponseDTO dto = new BookResponseDTO(
				book.getId(),
				book.getTitle(),
				authorMaps.get(book.getId()),
				book.getDescription()
				);
		
		return dto;
	}

}
