package com.erkennung.deutsch.grammar;

import com.erkennung.deutsch.grammar.constants.ArticleType;
import com.erkennung.deutsch.grammar.constants.Case;
import com.erkennung.deutsch.grammar.constants.Gender;
import com.erkennung.deutsch.grammar.constants.Number;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Articles {

    private final Set<ArticleForm> articles;

    public Set<ArticleForm> filter(Set<Case> cases, Set<Gender> genders, Set<Number> numbers, Set<ArticleType> types) {
        Stream<ArticleForm> filteredSet = articles.stream();

        if (cases != null && !cases.isEmpty()) {
            filteredSet = filteredSet.filter(articleForm -> cases.contains(articleForm.getGrammaticalCase()));
        }

        if (genders != null && !genders.isEmpty()) {
            filteredSet = filteredSet.filter(articleForm -> genders.contains(articleForm.getGender()));

        }

        if (numbers != null && !numbers.isEmpty()) {
            filteredSet = filteredSet.filter(articleForm -> numbers.contains(articleForm.getNumber()));
        }

        if (types != null && !types.isEmpty()) {
            filteredSet = filteredSet.filter(articleForm -> types.contains(articleForm.getArticleType()));
        }

        return filteredSet.collect(Collectors.toSet());
    }

    public Set<ArticleForm> getAllArticles() {
        return filter(null, null, null, null);
    }

    public ArticleForm getArticle(Case caze, Gender gender, Number number, ArticleType type) {
        Set<ArticleForm> forms = this.filter(Set.of(caze), Set.of(gender), Set.of(number), Set.of(type));
        if (forms != null && !forms.isEmpty()) {
            return (ArticleForm) forms.toArray()[0];
        }

        return null;
    }

    public boolean checkArticle(String articleForm, Case caze, Gender gender, Number number, ArticleType type) {
        Set<ArticleForm> forms = this.filter(Set.of(caze), Set.of(gender), Set.of(number), Set.of(type));
        if (forms != null && !forms.isEmpty()) {
            return articleForm.equalsIgnoreCase(((ArticleForm) forms.toArray()[0]).getWord());
        }

        return false;
    }


    public Articles() {
        this.articles = new HashSet<>();
        this.initializeWithStandardArticles();
    }
    private void initializeWithStandardArticles() {

        /**********************************************************************************************/
        // Definite Articles
        /**********************************************************************************************/

        // Masculine Singular Definite Articles
        this.addArticle("der", Case.NOMINATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("den", Case.ACCUSATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("dem", Case.DATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("des", Case.GENITIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.DEFINITE);

        // Feminine Singular Definite Articles
        this.addArticle("die", Case.NOMINATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("die", Case.ACCUSATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("der", Case.DATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("der", Case.GENITIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.DEFINITE);

        // Neuter Singular Definite Articles
        this.addArticle("das", Case.NOMINATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("das", Case.ACCUSATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("dem", Case.DATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("des", Case.GENITIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);

        // Masculine Plural Definite Articles
        this.addArticle("die", Case.NOMINATIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.DEFINITE);
        this.addArticle("die", Case.ACCUSATIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.DEFINITE);
        this.addArticle("den", Case.DATIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.DEFINITE);
        this.addArticle("der", Case.GENITIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.DEFINITE);

        // Feminine Plural Definite Articles
        this.addArticle("die", Case.NOMINATIVE, Gender.FEMININE, Number.PLURAL, ArticleType.DEFINITE);
        this.addArticle("die", Case.ACCUSATIVE, Gender.FEMININE, Number.PLURAL, ArticleType.DEFINITE);
        this.addArticle("den", Case.DATIVE, Gender.FEMININE, Number.PLURAL, ArticleType.DEFINITE);
        this.addArticle("der", Case.GENITIVE, Gender.FEMININE, Number.PLURAL, ArticleType.DEFINITE);

        // Neuter Plural Definite Articles
        this.addArticle("die", Case.NOMINATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("die", Case.ACCUSATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("den", Case.DATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);
        this.addArticle("der", Case.GENITIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.DEFINITE);

        /**********************************************************************************************/
        // Indefinite Articles
        /**********************************************************************************************/

        // Masculine Singular Indefinite Articles
        this.addArticle("ein", Case.NOMINATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("einen", Case.ACCUSATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("einem", Case.DATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("eines", Case.GENITIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE);

        // Feminine Singular Indefinite Articles
        this.addArticle("eine", Case.NOMINATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("eine", Case.ACCUSATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("einer", Case.DATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("einer", Case.GENITIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE);

        // Neuter Singular Indefinite Articles
        this.addArticle("ein", Case.NOMINATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("ein", Case.ACCUSATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("einem", Case.DATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE);
        this.addArticle("eines", Case.GENITIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE);

        /**********************************************************************************************/
        // Indefinite Negative Articles
        /**********************************************************************************************/


        // Masculine Singular Definite Articles
        this.addArticle("kein", Case.NOMINATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keinen", Case.ACCUSATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keinem", Case.DATIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keines", Case.GENITIVE, Gender.MASCULINE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);

        // Feminine Singular Definite Articles
        this.addArticle("keine", Case.NOMINATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keine", Case.ACCUSATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keiner", Case.DATIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keiner", Case.GENITIVE, Gender.FEMININE, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);

        // Neuter Singular Definite Articles
        this.addArticle("kein", Case.NOMINATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("kein", Case.ACCUSATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keinem", Case.DATIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keines", Case.GENITIVE, Gender.NEUTER, Number.SINGULAR, ArticleType.INDEFINITE_NEGATIVE);

        // Masculine Plural Definite Articles
        this.addArticle("keine", Case.NOMINATIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keine", Case.ACCUSATIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keinen", Case.DATIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keiner", Case.GENITIVE, Gender.MASCULINE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);

        // Feminine Plural Definite Articles
        this.addArticle("keine", Case.NOMINATIVE, Gender.FEMININE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keine", Case.ACCUSATIVE, Gender.FEMININE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keinen", Case.DATIVE, Gender.FEMININE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keiner", Case.GENITIVE, Gender.FEMININE, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);

        // Neuter Plural Definite Articles
        this.addArticle("keine", Case.NOMINATIVE, Gender.NEUTER, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keine", Case.ACCUSATIVE, Gender.NEUTER, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keinen", Case.DATIVE, Gender.NEUTER, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);
        this.addArticle("keiner", Case.GENITIVE, Gender.NEUTER, Number.PLURAL, ArticleType.INDEFINITE_NEGATIVE);

    }

    private void addArticle(String word, Case caze, Gender gender, Number number, ArticleType type) {
        this.articles.add(new ArticleForm(word, caze, gender, number, type));
    }
}
