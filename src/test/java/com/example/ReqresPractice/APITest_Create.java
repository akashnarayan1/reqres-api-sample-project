package com.example.ReqresPractice;

import io.restassured.response.Response;

import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class APITest_Create {
    APIMethods apiMethods = new APIMethods();
    Object obj = new JSONParser().parse(new FileReader("src/main/resources/sample_body.json"));
    JSONObject jsonObject = (JSONObject) obj;

    public APITest_Create() throws IOException, ParseException {
    }

    @Test
    public void testCreate_createUserResponseCode() throws IOException {
        Response response = apiMethods.create_user("create_user",jsonObject);
        assertThat(response.statusCode()).isEqualTo(201);
    }

    @Test
    public void testCreate_createUserValidateIdKeyReturned() throws FileNotFoundException {
        Response response = apiMethods.create_user("create_user",jsonObject);
        assertThat(response.getBody().asString()).contains("id");
    }

    @Test
    public void testCreate_createUserValidateNameAndJob() throws FileNotFoundException {
        apiMethods.create_user("create_user",jsonObject).
                then().
                body("name", equalTo(jsonObject.get("name")),
                        "job", equalTo(jsonObject.get("job")));
//        Response response = apiMethods.create_user("create_user",jsonObject);
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        String nameReceived = jsonPathEvaluator.get("name");
//        assertThat(nameReceived).isEqualTo(jsonObject.get("name"));
    }
}
