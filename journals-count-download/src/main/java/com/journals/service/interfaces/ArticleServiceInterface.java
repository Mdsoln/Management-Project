package com.journals.service.interfaces;

import com.journals.entity.Article;
import com.journals.models.ArticleCountDownloadsRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArticleServiceInterface {

    void saveArticle(MultipartFile file) throws IOException;

    Article downloadArticleByName(String name);

    ArticleCountDownloadsRequest retrivenumberofdownload(String name);

    List<ArticleCountDownloadsRequest> getAllArticleDownloads();

}
