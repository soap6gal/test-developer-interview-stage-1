package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.SearchFor;
import com.db.am.bauhaus.project.SelectDropDownMenuItem;
import com.db.am.bauhaus.project.SelectCategoryIcon;
import com.db.am.bauhaus.project.SearchTarget;
import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.steplib.SearchUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchSteps {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    SearchUser user;

    MainSearchPage mainSearchPage;

    @Given("^John is viewing the Etsy landing page$")
    public void goto_landing_page() {
        mainSearchPage.open();
    }

    @Given("^([^\\s]+) is viewing the Etsy landing page \\(screenplay\\)$")
    public void goto_landing_page_screenplay(String theUser) {
        theActorCalled(theUser).attemptsTo(Open.browserOn().the(mainSearchPage));
    }

    @When("^he searches for a product from the input box$")
    public void search_from_input_box() {
        user.search_from_input_box();
    }

    @When("^he searches for a product from the input box \\(screenplay\\)$")
    public void search_from_input_box_screenplay() {
        theActorInTheSpotlight().attemptsTo(SearchFor.randomText());
    }

    @When("^he searches for a product from the drop-down menu \\(screenplay\\)$")
    public void search_from_drop_down_menu_screenplay() {
        theActorInTheSpotlight().attemptsTo(SelectDropDownMenuItem.selectAnItem());
    }

    @When("^he clicks on a product icon \\(screenplay\\)$")
    public void click_on_product_icon_screenplay() {
        theActorInTheSpotlight().attemptsTo(SelectCategoryIcon.selectAnIcon());
    }

    @Then("^the input box search result should be displayed$")
    public void verify_input_box_search_result() {
        user.verify_result_for_top_categories();
        user.verify_result_for_all_categories();
    }

    @Then("^the input box search result should be displayed \\(screenplay\\)$")
    public void verify_input_box_search_result_screenplay() {
        String searchText = Serenity.sessionVariableCalled(SessionVar.SEARCH_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the input box search result ", the(SearchTarget.INPUT_BOX_SEARCH_RESULT_LIST), containsText(searchText))
        );
    }

    @Then("^the drop-down menu search result should be displayed \\(screenplay\\)$")
    public void verify_drop_down_search_result_screenplay() {
        String subMenuItem = Serenity.sessionVariableCalled(SessionVar.DROPDOWN_SUBMENU_ITEM).toString();
        theActorInTheSpotlight().should(
                seeThat("the drop-down menu item ", the(SearchTarget.DROPDOWN_SUBMENU_ITEM), containsText(subMenuItem))
        );
    }

    @Then("^the relevant product matrix should be displayed \\(screenplay\\)$")
    public void verify_product_icon_click_result_screenplay() {
        String productIconPageHeaderText = Serenity.sessionVariableCalled(SessionVar.JEWELLERY_SHOP_PAGE_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the product icon page header ", the(SearchTarget.JEWELLERY_SHOP_PAGE), containsText(productIconPageHeaderText))
        );
    }
}
