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

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by sjwilliams on 17/08/2017.
 */
public class SelectCategoryIcon implements Task {

    private String productIconPageHeaderText;
    private final static List<String> productIconList =
            Arrays.asList("Home &amp; Living", "Jewellery", "Clothing", "Craft Supplies &amp; Tools", "Weddings", "Games &amp; Toys");

    @Step("{0} selects a product icon")
    public <T extends Actor> void performAs(T theUser) {
        theUser.should(
                seeThat("the product icons are visible", the(SearchTarget.JEWELLERY_SHOP_ICON), isVisible())
        );

        theUser.attemptsTo(
                Click.on(SearchTarget.JEWELLERY_SHOP_ICON)  // TODO - generalize the icon, allowing random selection from the list, and grab the icon link text for subsequent match test.
        );
        Serenity.setSessionVariable(SessionVar.JEWELLERY_SHOP_PAGE_TEXT).to(productIconPageHeaderText);
    }

    public static SelectCategoryIcon selectAnIcon() {
        String productIconPageHeaderText = productIconList.get(1);  // TODO - randomize the selection from the productIconList & use link text to match product page.
        return Instrumented.instanceOf(SelectCategoryIcon.class).withProperties(productIconPageHeaderText);
    }

    public SelectCategoryIcon(String productIconPageHeaderText) {
        this.productIconPageHeaderText = productIconPageHeaderText;
    }
}