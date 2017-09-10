package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.NavigateTo;
import com.db.am.bauhaus.project.SearchTarget;
import com.db.am.bauhaus.project.SessionVar;
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
 * Created by Steve Williams on 18/10/2017.
 */
public class NavigationSteps {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    SearchUser user;

    @When("^he clicks on the sign-in button \\(screenplay\\)$")
    public void click_on_signin_button_screenplay() {
        theActorInTheSpotlight().attemptsTo(NavigateTo.loginPage());
    }

    @Then("^the login page should be presented \\(screenplay\\)$")
    public void verify_login_page_presented() {
        String loginText = Serenity.sessionVariableCalled(SessionVar.LOGIN_SCREEN_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the login screen is present ", the(SearchTarget.LOGIN_SCREEN_TEXT), containsText(loginText))
        );
    }

}
