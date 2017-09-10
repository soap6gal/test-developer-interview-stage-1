package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.GoogleSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GoogleUser extends ScenarioSteps {

    GoogleSearchPage googleSearchPage;

    String searchText = "cheese";

    @Step
    public void enterCheese() {
        googleSearchPage.searchFromInputBox(searchText);
    }

    @Step
    public void clickSearch() {
        googleSearchPage.clickSearch();
    }

    @Step
    public void verifyResults() {
        assertThat(googleSearchPage.getResults().toLowerCase(), containsString(searchText));
    }

}
