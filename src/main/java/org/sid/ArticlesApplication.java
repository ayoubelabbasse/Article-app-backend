package org.sid;

import org.sid.entities.Article;
import org.sid.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticlesApplication implements CommandLineRunner {

	
	@Autowired
	private ArticleRepository articleRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(ArticlesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		articleRepository.save(new Article("everybody","one","one"));
		articleRepository.save(new Article("two","one","one"));
		articleRepository.save(new Article("three","one","one"));
		
		
	}
}
