package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("/")
public class WomenFashionShopProductPage extends PageObject {


    public WomenFashionShopProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleForProductCategorySearch(){
        return find(By.cssSelector("h1.finds-title-h1")).getText();
    }

}
