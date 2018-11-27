package org.sid.repositories;

import org.sid.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ArticleRepository extends JpaRepository<Article,Long> {
	@Query("select a from Article a where a.name like :x")
	
 public Page<Article> chercher(@Param("x") String mc,Pageable pageable);
}
