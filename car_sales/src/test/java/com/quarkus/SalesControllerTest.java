package com.quarkus;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class SalesControllerTest {



    @Test
    public void testEndpointPurchaseCar(){
        Response response = given()
                .when()
                .post("/purchase")
                .thenReturn();


        assert(response.statusCode() == 200);
        Log.info(response.getBody());
    }


    @Test
    public void testEndpointPurchaseMultipleCars(){
        Response response = given()
                .when()
                .post("/purchase/multi")
                .thenReturn();


        assert(response.statusCode() == 200);
        Log.info(response.getBody());
    }
}
