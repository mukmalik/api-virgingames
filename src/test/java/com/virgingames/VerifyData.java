package com.virgingames;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VerifyData
{
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com/api/jackpots";
        //RestAssured.port = 3030;
        response = given()
                .when()
                .get("/bingo")
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        response.body("data.pots[1].id",equalTo("309"))
                .body("data.pots[1].name", equalTo("virgingamessession"))
                //.body("data.pots[1].amount", hasItem(7239.71F))
                .body("data.pots[1].currency", equalTo("GBP"));
    }

}
