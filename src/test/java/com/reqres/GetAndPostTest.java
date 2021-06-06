package com.reqres;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.RestAssured.get;

public class GetAndPostTest {
    @BeforeTest
    public void setup(){
        baseURI = "https://reqres.in/";
    }
    @Test
    public void getTest(){
                given().get("api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems( "George", "Rachel","Byron", "Tobias", "Lindsay", "Michael"));
    }
    @Test
    public void postTest(){
        //Create Json Objects
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("First Name" ,"Amit");
        jsonObject.put("Last Name", "Pradhan");
        jsonObject.put("Hobbies", "Music");
        System.out.println(jsonObject.toJSONString());

        //Post json
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .post("api/users")
                .then()
                .statusCode(201)
                .log().all();
    }
}
