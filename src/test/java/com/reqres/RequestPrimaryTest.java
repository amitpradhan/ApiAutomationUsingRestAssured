package com.reqres;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;


public class RequestPrimaryTest {

//    Response response;
//
//    @BeforeTest
//    public void setUp(){
////        response = get("https://reqres.in/api/users?page=2");
//
//    }
//    @Test
//    public void checkStatusCode(){
//        Assert.assertEquals(response.getStatusCode(), 200, "Status code not matching.");
//    }
//    @Test
//    public void printRequestDetails(){
//        System.out.println("Status code is -> "+response.getStatusCode());
//        System.out.println("Time taken to execute ->"+response.getTime());
//        System.out.println("Body-> "+response.getBody());
//        System.out.println("Status Line -> "+response.getStatusLine());
//        System.out.println("Content Type ->"+response.getHeader("content-type"));
//    }

    @Test
    public void testUsingHamcrest(){
        baseURI = "https://reqres.in/api";
                given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[1].id", equalTo(8))
                        .log().all();


    }



}
