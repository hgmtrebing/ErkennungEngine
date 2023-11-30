package com.erkennung.erkennungapi.german;

import com.erkennung.deutsch.grammar.ArticleForm;
import com.erkennung.deutsch.grammar.Articles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Validated
@Tag(
        name = "Articles",
        description = "Reference API for German Articles"
)
@RestController
public class GermanArticleController {

    private Articles articles;

    @Autowired
    public GermanArticleController(Articles articles) {
        this.articles = articles;
    }

    @Operation(
            operationId = "getAllArticles",
            summary = "Retrieve a Master List of Articles.",
            description = "Retrieve a Master List of German Articles.",
            tags = {"Articles"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Successful Retrieval of German Articles.",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = ArticleForm.class
                                    )
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/api/v1/german/articles/get-all"},
            produces = {"application/json"}
    )
    public ResponseEntity<Set<ArticleForm>> getAllArticles() {
        return ResponseEntity.ok(articles.getAllArticles());
    }
}
