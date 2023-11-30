package com.erkennung.erkennungapi.german;

import com.erkennung.deutsch.grammar.ArticleForm;
import com.erkennung.deutsch.grammar.Articles;
import com.erkennung.deutsch.grammar.constants.ArticleType;
import com.erkennung.deutsch.grammar.constants.Case;
import com.erkennung.deutsch.grammar.constants.Gender;
import com.erkennung.deutsch.grammar.constants.Number;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Operation(
            operationId = "getFilteredArticles",
            summary = "Retrieve a Filtered List of Articles.",
            description = "Retrieve a Filtered List of German Articles.",
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
            value = {"/api/v1/german/articles/get-filtered"},
            produces = {"application/json"}
    )
    public ResponseEntity<Set<ArticleForm>> getFilteredArticles(Gender[] genders,
                                                                Number[] numbers,
                                                                Case[] cases,
                                                                ArticleType[] types) {

         return ResponseEntity.ok(articles.filter(
                 Arrays.stream(cases).collect(Collectors.toSet()),
                 Arrays.stream(genders).collect(Collectors.toSet()),
                 Arrays.stream(numbers).collect(Collectors.toSet()),
                 Arrays.stream(types).collect(Collectors.toSet()))
         );
    }

    @Operation(
            operationId = "getIndividualArticle",
            summary = "Retrieve an Individual Articles.",
            description = "Retrieve an individual German Articles.",
            tags = {"Articles"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Successful Retrieval of German Article.",
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
            value = {"/api/v1/german/articles/get-individual"},
            produces = {"application/json"}
    )
    public ResponseEntity<ArticleForm> getIndividualArticle(Gender gender, Number number, Case caze, ArticleType type) {
        return ResponseEntity.ok(articles.getArticle(caze, gender, number, type));
    }

    @Operation(
            operationId = "checkArticle",
            summary = "Checks the correctness of an Article",
            description = "Checks that an Article has the correct Gender, Number, Case, and Article Type.",
            tags = {"Articles"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Article successfully checked.",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Boolean.class)
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/api/v1/german/articles/check-article"},
            produces = {"application/json"}
    )
    public ResponseEntity<Boolean> checkArticle(String articleForm, Gender gender, Number number, Case caze, ArticleType type) {
        return ResponseEntity.ok(articles.checkArticle(articleForm, caze, gender, number, type));
    }


}
