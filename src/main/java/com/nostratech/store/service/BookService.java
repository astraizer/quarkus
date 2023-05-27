package com.nostratech.store.service;

import com.nostratech.store.domain.Book;
import com.nostratech.store.dto.BookCreateRequestDTO;
import com.nostratech.store.dto.BookResponseDTO;

public interface BookService {
	
	public void createBook(BookCreateRequestDTO dto);
	
	public BookResponseDTO findBookById(Long id);
	


}
