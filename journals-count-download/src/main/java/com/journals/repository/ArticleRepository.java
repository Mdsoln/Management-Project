package com.journals.repository;

import com.journals.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    Article findByArticleName(String name);

    Article findByArticleId(Long articleId);

    /*
    List<Article> findByNameLike(String name)
    * */
}

