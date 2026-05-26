package org.example.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class PaymentApiMethodSourceTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> paymentData() {

        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(
                        "123e4567-e89b-12d3-a456-426614174000",
                        200,
                        true
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        "987f6543-e21b-34d3-b654-123456789abc",
                        200,
                        false
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        "11111111-2222-3333-4444-555555555315",
                        404,
                        null
                )
        );
    }

    @Test
//    @ParameterizedTest
//    @MethodSource("paymentData")
    @Tag("eugen")
    void shouldValidatePayments(
//            String paymentId,
//            int expectedStatus,
//            Boolean paid
    ) {

        var response =
                given()
                        .baseUri("http://localhost:8089")

                        .when()
                        .get("/payment/" + "987f6543-e21b-34d3-b654-123456789abc")

                        .then()
                        .statusCode(200);

        if (response.extract().statusCode() == 200) {
            response.body("paid",
                    org.hamcrest.Matchers.equalTo(false));
        }
    }

    @Test
//    @ParameterizedTest
//    @MethodSource("paymentData")
    @Tag("eugen")
    void shouldValidatePayments2(
//            String paymentId,
//            int expectedStatus,
//            Boolean paid
    ) {

        var response =
                given()
                        .baseUri("http://localhost:8089")

                        .when()
                        .get("/payment/" + "123e4567-e89b-12d3-a456-426614174000")

                        .then()
                        .statusCode(200);

        if (response.extract().statusCode() == 200) {
            response.body("paid",
                    org.hamcrest.Matchers.equalTo(true));
        }
    }

    @Test
//    @ParameterizedTest
//    @MethodSource("paymentData")
    @Tag("eugen")
    void shouldValidatePayments3(
//            String paymentId,
//            int expectedStatus,
//            Boolean paid
    ) {

        var response =
                given()
                        .baseUri("http://localhost:8089")

                        .when()
                        .get("/payment/" + "11111111-2222-3333-4444-555555555315")

                        .then()
                        .statusCode(404);

        if (response.extract().statusCode() == 404) {
            response.body("paid",
                    org.hamcrest.Matchers.equalTo(null));
        }
    }
}