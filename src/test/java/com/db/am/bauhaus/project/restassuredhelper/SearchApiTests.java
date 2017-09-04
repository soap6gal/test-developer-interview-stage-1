package com.db.am.bauhaus.project.restassuredhelper;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by bsimhadri on 13/08/2017.
 */
public class SearchApiTests extends BaseClass{
    @Test
    public void testSearchEndpointStatusCode() throws URISyntaxException {  //status code = 200
        given()
                .accept(ContentType.JSON)
                .when().get(new URI("/uk/search?q=dress&explicit=1&locationQuery=2639389"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testSearchApiResponse() throws URISyntaxException{

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");

        String body =  given()
                .headers(headers)
                .when()
                .get(new URI("/uk/search?q=dress&explicit=1&locationQuery=2639389"))
                .thenReturn()
                .body()
                .asString();
        System.out.println(body);
    }
}
