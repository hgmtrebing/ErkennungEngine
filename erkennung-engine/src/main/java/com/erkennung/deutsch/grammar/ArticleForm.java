package com.erkennung.deutsch.grammar;

import com.erkennung.deutsch.grammar.constants.ArticleType;
import com.erkennung.deutsch.grammar.constants.Case;
import com.erkennung.deutsch.grammar.constants.Gender;
import com.erkennung.deutsch.grammar.constants.Number;

import java.util.Objects;

public class ArticleForm {

    private final String word;
    private final Case grammaticalCase;
    private final Gender gender;
    private final Number number;
    private final ArticleType articleType;

    public ArticleForm(String word, Case grammaticalCase, Gender gender, Number number, ArticleType articleType) {
        this.word = word;
        this.grammaticalCase = grammaticalCase;
        this.gender = gender;
        this.number = number;
        this.articleType = articleType;
    }

    public String getWord() {
        return word;
    }

    public Case getGrammaticalCase() {
        return grammaticalCase;
    }

    public Gender getGender() {
        return gender;
    }

    public Number getNumber() {
        return number;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleForm that = (ArticleForm) o;
        return Objects.equals(word, that.word) && grammaticalCase == that.grammaticalCase && gender == that.gender && Objects.equals(number, that.number) && articleType == that.articleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, grammaticalCase, gender, number, articleType);
    }
}
