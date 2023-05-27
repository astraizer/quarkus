package com.nostratech.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record BookCreateRequestDTO(String title, 
	@JsonProperty("author_id")	
	Long authorId, 
	String description) {

	
	
}
