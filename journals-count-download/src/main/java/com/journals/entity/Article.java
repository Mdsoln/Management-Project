package com.journals.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "articles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @Column(name = "Title",nullable = false)
    private String articleName;
    @Column(name = "Document Type",nullable = false)
    private String articleType;
    @Column(name = "Directory Path",nullable = false)
    private String articlePath;
    @Column(name = "Document Size",nullable = false)
    private String articleSize;
    @Column(nullable = false)
    /*means the number of which an article(s) have been downloaded*/
    private Integer downloads;
}
