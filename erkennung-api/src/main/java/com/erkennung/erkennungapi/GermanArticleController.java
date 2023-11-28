package com.erkennung.erkennungapi;

import com.erkennung.erkennungapi.german.api.ArticlesApi;
import com.erkennung.erkennungapi.german.model.GermanArticle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GermanArticleController implements ArticlesApi {

    @Override
    public ResponseEntity<List<GermanArticle>> getAllArticles() {
        return null;
    }
}
