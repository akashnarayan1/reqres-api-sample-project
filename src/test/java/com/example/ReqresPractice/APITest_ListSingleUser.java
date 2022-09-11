package com.example.ReqresPractice;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class APITest_ListSingleUser {
    APIMethods apiMethods = new APIMethods();

    public APITest_ListSingleUser() throws FileNotFoundException {
    }
    @Test
    public void testSingleUser_getSingleUser() throws FileNotFoundException {
        Response response = apiMethods.single_user("list_singleUser", "2");
        assertThat(response.statusCode()).isEqualTo(200);
    }
}
