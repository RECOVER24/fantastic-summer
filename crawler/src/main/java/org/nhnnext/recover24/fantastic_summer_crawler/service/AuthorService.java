package org.nhnnext.recover24.fantastic_summer_crawler.service;

import org.nhnnext.recover24.fantastic_summer_crawler.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

}
