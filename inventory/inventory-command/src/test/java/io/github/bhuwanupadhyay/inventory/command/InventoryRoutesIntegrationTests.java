package io.github.bhuwanupadhyay.inventory.command;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

class InventoryRoutesIntegrationTests {

    @Test
    void can_add_product() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri("http://localhost:" + 9001)
                .body("{ \"name\" : \"Watch\"}")
                .post("/inventories")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}