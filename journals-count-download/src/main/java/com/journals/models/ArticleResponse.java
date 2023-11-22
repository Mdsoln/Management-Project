package com.journals.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/*This class mainly used to extract details for the file/article/book uploaded from web
and give its details to Article entity. Also, this class used to give back response to the client
with generated download url link of specific article.
* */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleResponse {
    private String articleName;
    private String articleType;
    private String articleSize;
    private String downloadURL;
}
