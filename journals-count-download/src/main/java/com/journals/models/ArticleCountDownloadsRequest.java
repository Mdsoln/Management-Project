package com.journals.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*This class mainly used to deliver response to the client especially user with role Admin/Editor
with the number of which an article have been downloaded. It may also deliver for all books
depends on the request.
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCountDownloadsRequest {
    private String article_name;
    private Integer number_of_downloads;
}
