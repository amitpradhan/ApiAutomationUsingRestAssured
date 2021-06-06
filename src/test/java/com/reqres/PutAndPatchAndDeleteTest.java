package com.reqres;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutAndPatchAndDeleteTest {

    JSONObject jsonObject;
    @BeforeTest
    public void setup(){
        baseURI = "https://reqres.in";
        jsonObject = new JSONObject();
        jsonObject.put("Name", "Amit");
        jsonObject.put("Hobby", "Reading");
    }
    @Test
    public void putTest(){
            given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void patchTest(){
            given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void deleteTest(){
               when()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .log().all();

    }

}
