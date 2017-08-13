package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.pages.WomenFashionShopProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;
    WomenFashionShopProductPage womenFashionShopProductPage;

    String searchText = "craft";
    String[] categoriesList = {"Weddings", "Clothing", "Dresses"};
    String productSearchText = "Women's fashion shop";

    @Step
    public void search_from_input_box() {
        mainSearchPage.searchFromInputBox(searchText);
    }

    @Step
    public void selects_a_category_from_dropdown_menu(){
        mainSearchPage.selectCategories(categoriesList);
    }

    @Step
    public void selects_a_category_from_icon(){
        mainSearchPage.scrollDownOrUp(600);
        mainSearchPage.clickOnCategoryFromProductIcon();
    }

    @Step
    public void verify_result_for_category_search_dropdown_grid(){
        assertThat(mainSearchPage.getHeaderForCategorySearch(), containsString(categoriesList[2]));
    }

    @Step
    public void verify_result_for_category_search_product_icon(){
        assertThat(womenFashionShopProductPage.getTitleForProductCategorySearch(), containsString(productSearchText));
    }

    @Step
    public void verify_result_for_top_categories() {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void verify_result_for_all_categories() {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(searchText));
    }
}
