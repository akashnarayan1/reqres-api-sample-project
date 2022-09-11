package com.example.ReqresPractice;

import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.yaml.snakeyaml.Yaml;


public class APIMethods {
    Yaml yaml = new Yaml();
    InputStream inputStream = new FileInputStream((new File("src/main/resources/config.yml")));
    HashMap configMap = yaml.load(inputStream);
    InputStream inputStream2 = new FileInputStream((new File("src/main/resources/endpoints.yml")));
    HashMap endpointMap = yaml.load(inputStream2);

    public APIMethods() throws FileNotFoundException {
    }


    public RequestSpecificationImpl createRequest() throws FileNotFoundException {
        RestAssured.baseURI = "https://" + configMap.get("baseURL");
        return (RequestSpecificationImpl) RestAssured.given();
    }

    public Response list_user(String list_endpoint, String ... param) throws FileNotFoundException {
        String endpoint = param.length > 0 ? (String) endpointMap.get(list_endpoint) + param[0] : (String) endpointMap.get(list_endpoint);
        // Real HTTPS call
        return createRequest().get(endpoint);
    }

    public Response create_user(String create_endpoint, JSONObject body) throws FileNotFoundException {
        RequestSpecificationImpl httpsRequest = createRequest();
        httpsRequest.header("Content-Type", "application/json");
        httpsRequest.body(body);
        String endpoint = (String) endpointMap.get(create_endpoint);
        return httpsRequest.post(endpoint);
    }

    public Response single_user(String single_user_endpoint, String id) throws FileNotFoundException {
        return createRequest().get((String) endpointMap.get(single_user_endpoint) + id);
    }

    public Response register_user(String register_endpoint, JSONObject body) throws FileNotFoundException {
        RequestSpecificationImpl httpsRequest = createRequest();
        httpsRequest.header("Content-Type", "application/json");
        httpsRequest.body(body);
        String endpoint = (String) endpointMap.get(register_endpoint);
        return httpsRequest.post(endpoint);
    }
    public Response login_user(String login_endpoint, JSONObject body) throws FileNotFoundException {
        RequestSpecificationImpl httpsRequest = createRequest();
        httpsRequest.header("Content-Type", "application/json");
        httpsRequest.body(body);
        String endpoint = (String) endpointMap.get(login_endpoint);
        return httpsRequest.post(endpoint);
    }

}
