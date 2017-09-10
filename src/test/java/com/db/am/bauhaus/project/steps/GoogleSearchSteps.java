package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.SearchFor;
import com.db.am.bauhaus.project.SelectDropDownMenuItem;
import com.db.am.bauhaus.project.SelectCategoryIcon;
import com.db.am.bauhaus.project.SearchTarget;
import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.pages.GoogleSearchPage;
import com.db.am.bauhaus.project.steplib.GoogleUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

public class GoogleSearchSteps {

    // Step library to abstract the logic from step defs
    @Steps
    GoogleUser googleUser;

    GoogleSearchPage googleSearchPage;

    @Given("^I am on the Google Home page$")
    public void goto_landing_page() {
        googleSearchPage.open();
    }

    @When("^I enter cheese into the search box$")
    public void enter_cheese_into_the_search_box() {
        googleUser.enterCheese();
    }

    @When("^I click search$")
    public void click_search() {
        googleUser.clickSearch();
    }

    @Then("^I should see results showing cheese$")
    public void verify_cheesey_results() {
        googleUser.verifyResults();
    }

}