package com.journals.service.impl;

import com.journals.entity.Article;
import com.journals.repository.ArticleRepository;
import com.journals.service.interfaces.EditorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditorServiceImpl implements EditorServiceInterface {
     private final ArticleRepository articleRepository;
    @Override
    public void deleteArticleById(Long articleId) {
        Article article = articleRepository.findByArticleId(articleId);
        if (article != null){
            articleRepository.delete(article);
        }
    }

    @Override
    public void deleteArticleByName(String articleName) {
        Article article = articleRepository.findByArticleName(articleName);
        if (article != null){
            articleRepository.delete(article);
        }
    }
}
