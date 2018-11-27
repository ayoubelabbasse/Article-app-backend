package org.sid.controllers;

import java.util.List;
import java.util.Optional;

import org.sid.entities.Article;
import org.sid.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/articles")
	public List<Article> getArticles(){
		return articleRepository.findAll();
	}
	

	@GetMapping("/article/{id}")
	public Optional<Article> getArticle(@PathVariable Long id ){
		return articleRepository.findById(id);
	}
	
	@DeleteMapping("/article/{id}")
	public boolean  deleteArticle(@PathVariable Long id ){
		 articleRepository.deleteById(id);
		 return true;
	}
	
	@PostMapping("/article")
	public Article createArticle(@RequestBody Article article ){
		return articleRepository.save(article);
	}
	
	@PutMapping("/article")
	public Article updateArticle(@RequestBody Article article ){
		return articleRepository.save(article);
	}
	
	
	@SuppressWarnings("deprecation")
	@GetMapping("/chercherarticles")
	@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
	public  Page<Article> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			
			@RequestParam(name="page",defaultValue="0")int page,
		
			@RequestParam(name="size",defaultValue="4")int size ){
		return articleRepository.chercher("%"+mc+"%", new PageRequest(page,size) );
	}
	
}
