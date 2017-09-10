package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

@DefaultUrl("/")
public class GoogleSearchPage extends PageObject {

    @FindBy(name = "q")
    WebElementFacade inputBox;

    @FindBy(name = "btnK")
    WebElementFacade searchButton;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
    }

    public void clickSearch() {
        // searchButton.click();
        inputBox.waitUntilPresent().sendKeys(Keys.RETURN);
    }

    public String getResults() {
        return find(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/h3/a")).getText();
    }
}
