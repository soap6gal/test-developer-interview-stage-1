package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;

   // String searchText = "craft";

    @Step
    public void search_from_input_box(String searchText) {
        mainSearchPage.searchFromInputBox(searchText);
    }

    @Step
    public void verify_result_for_top_categories(String searchText) {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void verify_result_for_all_categories(String searchText) {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(searchText));
    }
    
    @Step
    public void search_from_drop_down_menu(String product) {
        mainSearchPage.selectDropdown(product);
        
    
    }

	public void click_jewellery_icon() {
		mainSearchPage.click_jewellery_icon();
	
		
	}
}
