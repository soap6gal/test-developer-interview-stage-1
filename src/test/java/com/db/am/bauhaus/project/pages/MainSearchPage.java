package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".btn.btn-primary")
    WebElementFacade searchButton;

    @FindBy(css=".vesta-hp-gifts-card-title")
    WebElementFacade categoryFromGiftProductIcon;

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public void selectCategories(String[] categoryHierarchyNames){
        for (String category : categoryHierarchyNames) {
            clickOnCategory(category) ;
        }
    }

    public void clickOnCategory(String category){
        scrollIntoCategoryViewAndClick(category);
    }

    public void scrollIntoCategoryViewAndClick(String category){
        if(find(By.linkText(category)).isDisplayed() == false){
            js.executeScript("document.querySelector(\"" + category + "\"). scrollIntoView(true);");
        }
        clickOn(find(By.linkText(category)));
    }

    public void backToHomePage(){
        find(By.cssSelector("[aria-label='Etsy Logo']")).click();
    }

    public void clickOnCategoryFromProductIcon(){
        clickOn(categoryFromGiftProductIcon);
    }

    public String getHeaderForCategorySearch(){
        return find(By.cssSelector("div.float-left h1")).getText();
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector("h1.display-inline")).getText();
    }

    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.display-inline")).getText();
    }

    public void scrollDownOrUp(int value) {
        js.executeScript("scroll(0, \""+value+"\");");
    }
}
