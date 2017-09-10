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
 * Created by sjwilliams on 17/08/2017.
 */
public class SelectDropDownMenuItem implements Task {

    private String subMenuItem;
    private final static String DROPDOWN_SUBMENU_ITEM = "Accessories"; // TODO - add at least one more of the options and randomise

    @Step("{0} selects an item from the drop-down menu")
    public <T extends Actor> void performAs(T theUser) {
        theUser.should(
                seeThat("the drop-down menu is visible", the(SearchTarget.DROPDOWN_MENU), isVisible())
        );

        theUser.attemptsTo(Click.on(SearchTarget.DROPDOWN_MENU_ITEM));
        Serenity.setSessionVariable(SessionVar.DROPDOWN_SUBMENU_ITEM).to(subMenuItem);
    }

    public static SelectDropDownMenuItem selectAnItem() {
        return Instrumented.instanceOf(SelectDropDownMenuItem.class).withProperties(DROPDOWN_SUBMENU_ITEM);
    }

    public SelectDropDownMenuItem(String DROPDOWN_SUBMENU_ITEM) {
        this.subMenuItem = DROPDOWN_SUBMENU_ITEM;
    }

}
