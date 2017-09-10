package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.EtsyApiActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.containsString;

public class EtsyApiSteps {

    @Steps
    private EtsyApiActions etsyApiActions; // this should be in steplib. It's a steps library like SearchUser.java

    @When("^I search for the keyword (.*)$")
    public void whenIsearchForTheKeyword(String keyword) {
        etsyApiActions.searchForKeyword(keyword);
    }

    @When("^I click a sub category link$")
    public void whenIclickAsubCategoryLink() {
        etsyApiActions.clickSubCategory();
    }

    @Then("^I should get a response code (\\d+)$")
    public void thenIshouldGetAresponseCode(int expectedStatusCode) {
        assertThat(etsyApiActions.getStatusCode(), equalTo(expectedStatusCode));
    }

    @Then("^I should get results from the keyword$")
    public void thenIshouldGetResultsFromTheKeyword() {
        assertThat(etsyApiActions.getResponseResultsTally(), greaterThan(0));
    }

    @Then("^I should get relevant results from the keyword (.*)")
    public void thenIshouldGetRelevantResultsFromTheKeyword(String keyword) {
        ArrayList<String> resultsArray = new ArrayList<String>();
        resultsArray = etsyApiActions.getResponseResultsKeyword();
        String result = resultsArray.get(0);

        assertThat(result.toLowerCase(), containsString(keyword));
    }

    @Then("^I should get the sub category nav JSON response$")
    public void thenIshouldGetTheSubCategoryNavJsonResponse() {
        assertThat(etsyApiActions.getCategorySubNavResponse(), containsString("CategoryNav_Nav_View_SubNav"));
    }
}
