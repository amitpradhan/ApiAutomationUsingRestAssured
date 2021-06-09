package com.reqres;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class JsonSchemaValidatorTest {

    /**
     * Step to validate JSON schema (https://github.com/rest-assured/rest-assured/wiki/Usage#json-schema-validation)
     * Step 1 : Create JSON Schema
     * Step 2 : Add JSON Schema file in classpath ( target/classes/Schema/json)
     * Step 3 : Add Maven dependency for JSON Schema Validator
     * Step 4 : Create a new function to validate json response against schema
     * Step 5 : Run & Validate
     */

    @BeforeTest
    public void setup(){
        baseURI = "https://reqres.in/";
    }
    @Test
    public void getTest(){
        given().get("api/users?page=2")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);
    }
}
