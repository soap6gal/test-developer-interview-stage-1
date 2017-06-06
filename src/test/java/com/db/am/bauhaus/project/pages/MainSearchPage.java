package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {
	

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".btn.btn-orange.btn-append")
    WebElementFacade searchButton;
    
    @FindBy(id="catnav-primary-link-1179-link")
    WebElementFacade navigateMenu;
<<<<<<< HEAD
=======
    
    @FindBy(xpath="//*[@id='content']/div/div/span[2]/div/div/div/div[2]/a/div[1]/picture/img")
    WebElementFacade jewelleryIcon;
>>>>>>> subhash

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector("h4.pb-xs-1-5")).getText();
    }

    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.conform-heading.display-inline")).getText();
    }

	public void selectDropdown(String menu) {
      selectFromDropdown(navigateMenu, menu);		
	}
<<<<<<< HEAD
=======
	
	public void click_jewellery_icon(){
		jewelleryIcon.click();
	}
>>>>>>> subhash
}
