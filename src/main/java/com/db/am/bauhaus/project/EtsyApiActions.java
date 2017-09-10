package com.db.am.bauhaus.project;

import static net.serenitybdd.rest.SerenityRest.rest;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;
import static net.serenitybdd.rest.SerenityRest.and;
import static net.serenitybdd.rest.SerenityRest.given;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;

public class EtsyApiActions {

    private String baseUrl = "https://www.etsy.com/shop_name_search_service";
    private String categoryUrl = "https://www.etsy.com/api/v3/ajax/public/category-nav/view/subnav?responsive_enabled=true";

    @Step
    public void searchForKeyword(String keyword) {
        HashMap<String, String> params = new HashMap<>();
        params.put("q", keyword);

        given().contentType("application/json")
                .and().params(params)
                .when().get(baseUrl);
    }

    @Step
    public int getStatusCode() {
        return then().extract().statusCode();
    }

    @Step
    public int getResponseResultsTally() {
        return then().extract().body().jsonPath().get("total_results_count");
    }

    @Step
    public ArrayList getResponseResultsKeyword() {
        return then().extract().body().jsonPath().get("results");
    }

    @Step
    public void clickSubCategory() {
        HashMap<String, String> params = new HashMap<>();
        params.put("responsive_enabled", "true");

        given().contentType("application/json")
                .and().params(params)
                .when().get(categoryUrl);
    }

    @Step
    public String getCategorySubNavResponse() {
        return then().extract().body().jsonPath().get("view_name");
    }
}
