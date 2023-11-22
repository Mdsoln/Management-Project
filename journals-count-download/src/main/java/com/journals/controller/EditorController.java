package com.journals.controller;

import com.journals.service.impl.EditorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
  This controller allows an Editor/Admin to delete, add, edite the article details in database and
  controls what articles should see to downloads
* */
@CrossOrigin()
@RestController
@RequestMapping(path = "/api/editor")
@RequiredArgsConstructor
public class EditorController {

    private final EditorServiceImpl editorService;

    @CrossOrigin()
    @DeleteMapping("/removeById")
    public ResponseEntity<String> deleteJournalById(@PathVariable Long articleId)
    {
        editorService.deleteArticleById(articleId);
        return new ResponseEntity<>("Article deleted successfully", HttpStatus.OK);
    }

    @CrossOrigin()
    @DeleteMapping("/removeByName")
    public ResponseEntity<String> deleteJournalByName(@PathVariable String articleName)
    {
        editorService.deleteArticleByName(articleName);
        return new ResponseEntity<>("Article deleted successfully",HttpStatus.OK);
    }
}
