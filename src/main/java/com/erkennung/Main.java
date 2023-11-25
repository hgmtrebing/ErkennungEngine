package com.erkennung;

import com.erkennung.deutsch.grammar.ArticleForm;
import com.erkennung.deutsch.grammar.Articles;
import com.erkennung.deutsch.grammar.constants.ArticleType;
import com.erkennung.deutsch.grammar.constants.Case;
import com.erkennung.deutsch.grammar.constants.Gender;
import com.erkennung.deutsch.grammar.constants.Number;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Articles a = new Articles();

        ArticleForm form = a.getArticle(Case.NOMINATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE);
        System.out.println("Word: " + form.getWord());
        System.out.println("Case: " + form.getGrammaticalCase());
        System.out.println("Gender: " + form.getGender());
        System.out.println("Number: " + form.getNumber());
        System.out.println("Type: " + form.getArticleType());
        /*
        Set<ArticleForm> filtered = a.filter(null, null, null, null);
        System.out.println(filtered.size());
        for (ArticleForm form: filtered) {
            System.out.println("--------------------");
            System.out.println("Word: " + form.getWord());
            System.out.println("Case: " + form.getGrammaticalCase());
            System.out.println("Gender: " + form.getGender());
            System.out.println("Number: " + form.getNumber());
            System.out.println("Type: " + form.getArticleType());
        }

         */
    }
}