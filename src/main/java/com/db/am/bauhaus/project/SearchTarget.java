package com.db.am.bauhaus.project;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by ongshir on 06/04/2017.
 */
public class SearchTarget {
    public final static Target INPUT_BOX = Target.the("the search input box").located(By.id("search-query"));
    public final static Target INPUT_BOX_BUTTON = Target.the("the search input button").located(By.cssSelector(".btn.btn-primary"));
    public final static Target TOP_CATEGORIES_HEADER = Target.the("the top categories header").located(By.cssSelector("h4.pb-xs-1-5"));
    public final static Target ALL_CATEGORIES_HEADER = Target.the("the all categories header").located(By.cssSelector("h1.conform-heading.display-inline"));
    public final static Target INPUT_BOX_SEARCH_RESULT_LIST = Target.the("the result list keyword").located(By.cssSelector("h1.display-inline.text-smaller"));
    public final static Target DROPDOWN_MENU = Target.the("the drop-down menu").located(By.cssSelector(".catnav-primary-list-parent.pl-xs-0"));
    public final static Target DROPDOWN_MENU_ITEM = Target.the("the drop-down menu item").located(By.xpath("//*[@id=\"catnav-primary-link-2938-link\"]"));
    public final static Target DROPDOWN_SUBMENU_ITEM = Target.the("the drop-down sub-menu item").located(By.xpath("//*[@id=\"category-nav-side-nav-3090-link\"]"));
    public final static Target JEWELLERY_SHOP_ICON = Target.the("the jewellery shop icon").located(By.xpath("//div[@class='block-grid-item vesta-hp-category-card' and .//a[@href='https://www.etsy.com/c/jewelry?anchor_listing_id=273831994&ref=hp']]"));
    public final static Target JEWELLERY_SHOP_PAGE = Target.the("the category page").located(By.xpath("//*[@id=\"content\"]/div[3]/div/div[1]/h1"));
    public final static Target SIGNIN_BUTTON = Target.the("the sign in button").located(By.cssSelector(".sign-in-link"));
    public final static Target LOGIN_SCREEN_TEXT = Target.the("the login screen text").located(By.xpath("//*[@id=\"ext-acct-signin\"]/div[1]/a/span"));
}
