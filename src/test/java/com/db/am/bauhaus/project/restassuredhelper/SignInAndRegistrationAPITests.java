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
public class SignInAndRegistrationAPITests extends BaseClass {

    @Test
    public void testSignInEndpointStatusCode() throws URISyntaxException {

        given()
                .accept(ContentType.JSON)
                .when().get(new URI("/overlays/signin-reg?from_url=%2F&from_action=signin-header&username_prefilled=&password_prefilled=&source=https%3A%2F%2Fwww.etsy.com%2F"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testRegistrationEndpointStatusCode() throws URISyntaxException{
        given()
                .accept(ContentType.JSON)
                .when().get(new URI("/overlays/signin-reg?from_url=%2F&from_action=register-header&username_prefilled=&password_prefilled=&source=https%3A%2F%2Fwww.etsy.com%2F"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testSignInEndpointResponse() throws URISyntaxException{

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");

        String body =  given()
                .headers(headers)
                .when()
                .get(new URI("/overlays/signin-reg?from_url=%2F&from_action=signin-header&username_prefilled=&password_prefilled=&source=https%3A%2F%2Fwww.etsy.com%2F"))
                .thenReturn()
                .body()
                .asString();
        System.out.println(body);
    }


    @Test
    public void testRegistrationEndpointResponse() throws URISyntaxException{

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");

        String body =  given()
                .headers(headers)
                .when()
                .get(new URI("/overlays/signin-reg?from_url=%2F&from_action=register-header&username_prefilled=&password_prefilled=&source=https%3A%2F%2Fwww.etsy.com%2F"))
                .thenReturn()
                .body()
                .asString();
        System.out.println(body);
    }
}
