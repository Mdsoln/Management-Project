package com.journals.controller;

import com.journals.entity.Article;
import com.journals.models.ArticleCountDownloadsRequest;
import com.journals.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@CrossOrigin()
@RequestMapping(path ="/api/articles")
@RestController
public class ArticleController {
    @Autowired
    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }


    /*api for uploading a file in directory and database*/
    @CrossOrigin()
    @PostMapping("/upload")
    public ResponseEntity<String> uploadArticle(
            @RequestParam(name = "file")MultipartFile file
    ) throws IOException {
        articleService.saveArticle(file);
        return ResponseEntity.ok("Article saved successfully");
    }

    /*generating a link for downloading an article given a name if its exists in database*/
    @CrossOrigin()
    @GetMapping("/download/{name}")
    public ResponseEntity<Resource> downloadUrlGenerator(@PathVariable String name){
        Article article = articleService.downloadArticleByName(name);
        if (article != null){
            Path uploadPath = Paths.get("D:/FRONTS/"+article.getArticleName());
            Resource resource = new FileSystemResource(uploadPath);
            if (resource.exists() && resource.isReadable()){
               return ResponseEntity.ok()
                       .header(HttpHeaders.CONTENT_DISPOSITION,"article; filename=\""+article.getArticleName()+"\"")
                       .body(resource);
            }

        }
        return ResponseEntity.notFound().build();
    }

    /*polling an article details with respective download url above corresponding to given name*/
     @CrossOrigin()
     @GetMapping("/articleDetails/{name}")
     public ResponseEntity<Article> pollingArticleDetails(@PathVariable String name){
         Article article = articleService.downloadArticleByName(name);
         if (article != null){
             return ResponseEntity.ok(article);
         }
         return ResponseEntity.notFound().build();
     }

     /*api for determining number of downloads for specific article*/
    @CrossOrigin()
    @GetMapping("/counts/{name}")
    public ResponseEntity<ArticleCountDownloadsRequest> numberOfDownloads(
           @PathVariable String name
    ){
        ArticleCountDownloadsRequest counts = articleService.retrivenumberofdownload(name);
        return new ResponseEntity<>(counts, HttpStatus.OK);
    }

    /*api for determining number of article that are found in database*/
    @CrossOrigin()
    @GetMapping("/countsAll")
    public ResponseEntity<List<ArticleCountDownloadsRequest>> numberOfAllArticles(){
        List<ArticleCountDownloadsRequest> counts = articleService.getAllArticleDownloads();
        return new ResponseEntity<>(counts,HttpStatus.OK);
    }
}
