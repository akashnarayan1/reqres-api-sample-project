package com.example.ReqresPractice;

import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import static org.assertj.core.api.Assertions.*;

public class APITest_ListUsers {
    APIMethods apiMethods = new APIMethods();

    public APITest_ListUsers() throws FileNotFoundException {
    }

    // Tests for all scenarios of /api/users?
    @Test
    public void testListUsers_getAllUsers() throws FileNotFoundException {
        Reporter.log("Entered : "+ new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName());
        Response response = apiMethods.list_user("list_users");
        Reporter.log("Status code received: " + response.statusCode());
        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    public void testListUsers_getSpecificPage() throws FileNotFoundException {
        Response response = apiMethods.list_user("list_users", "10");
        System.out.println(response.prettyPrint());
        assertThat(response.statusCode()).isEqualTo(200);
    }
}
