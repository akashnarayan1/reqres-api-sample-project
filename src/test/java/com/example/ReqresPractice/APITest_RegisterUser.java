package com.example.ReqresPractice;

import io.restassured.response.Response;

import java.io.*;
import org.json.simple.JSONObject;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class APITest_RegisterUser {

    APIMethods apiMethods = new APIMethods();

    public APITest_RegisterUser() throws FileNotFoundException {
    }

    @Test
    public void testRegister_successfulRegister() throws FileNotFoundException {
        JSONObject params = new JSONObject();
        params.put("email", "eve.holt@reqres.in");
        params.put("password", "pistol");
        Response response = apiMethods.register_user("register_user", params);
        assertThat(response.statusCode()).isEqualTo(200);

    }
    @Test
    public void testRegister_unsuccessfulRegister() throws FileNotFoundException {
        JSONObject params = new JSONObject();
        params.put("email", "eve.holt@reqres.in");
        Response response = apiMethods.register_user("register_user", params);
        Reporter.log("Response: " + response.prettyPrint());
        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    public void testRegister_containsId() throws FileNotFoundException {
        JSONObject params = new JSONObject();
        Reporter.log("Entered : "+ new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName());
        params.put("email", "eve.holt@reqres.in");
        params.put("password", "pistol");
        Response response = apiMethods.register_user("register_user", params);
        assertThat(response.getBody().asString()).contains("id");
        assertThat(response.getBody().asString()).contains("token");
        Reporter.log("Token Generated: " + response.then().contentType(JSON).extract().path("token"));
    }

}