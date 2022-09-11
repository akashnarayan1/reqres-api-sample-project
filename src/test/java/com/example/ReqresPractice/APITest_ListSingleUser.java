package com.example.ReqresPractice;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class APITest_ListSingleUser {
    APIMethods apiMethods = new APIMethods();

    public APITest_ListSingleUser() throws FileNotFoundException {
    }

    @Test
    public void testSingleUser_getSingleUser() throws FileNotFoundException {
        Response response = apiMethods.single_user("list_singleUser", "2");
        System.out.println(response.prettyPrint());
    }
}
