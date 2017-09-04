package com.db.am.bauhaus.project.restassuredhelper;

import org.junit.BeforeClass;
import static io.restassured.RestAssured.*;

/**
 * Created by bsimhadri on 13/08/2017.
 */
public class BaseClass {

    @BeforeClass
    public static void setUp(){

        baseURI="https://www.etsy.com";
        //port = 8080;
        //basePath = "/uk/search?q=dress";
    }
}
