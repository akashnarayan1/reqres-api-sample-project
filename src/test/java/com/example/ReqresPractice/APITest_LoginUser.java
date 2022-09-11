package com.example.ReqresPractice;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class APITest_LoginUser {
    APIMethods apiMethods = new APIMethods();

    public APITest_LoginUser() throws FileNotFoundException {
    }

    @Test
    public void testLogin_successfulLogin() throws FileNotFoundException {
        JSONObject params = new JSONObject();
        params.put("email", "eve.holt@reqres.in");
        params.put("password", "pistol");
        Response response = apiMethods.login_user("login_user", params);
        assertThat(response.statusCode()).isEqualTo(200);
    }

}
