package com.db.am.bauhaus.project;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by Steve Williams on 18/08/2017.
 */
public class NavigateTo implements Task {

    private String loginText;
    private final static String LOGIN_SCREEN_TEXT = "Sign in with Facebook";

    @Step("{0} clicks on the sign-in button")
    public <T extends Actor> void performAs(T theUser) {
        theUser.should(
                seeThat("the sign-in button is visible", the(SearchTarget.SIGNIN_BUTTON), isVisible())
        );

        theUser.attemptsTo(Click.on(SearchTarget.SIGNIN_BUTTON));
        Serenity.setSessionVariable(SessionVar.LOGIN_SCREEN_TEXT).to(loginText);
    }

    public static NavigateTo loginPage() {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(LOGIN_SCREEN_TEXT);
    }

    public NavigateTo(String LOGIN_SCREEN_TEXT) {
        this.loginText = LOGIN_SCREEN_TEXT;
    }


}
