package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openapitools.client.api.BreedsApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SpringApplication.run(Main.class, args);

        RestAssured.baseURI = "https://dogapi.dog";

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v2/breeds/e7e99424-d514-4b56-9f0c-05736f6dd22d")
                .then()
                .log()
                .all()
                .statusCode(200)
                .contentType(ContentType.JSON)

                // data
                .body("data.id", org.hamcrest.Matchers.equalTo("e7e99424-d514-4b56-9f0c-05736f6dd22d"))
                .body("data.type", org.hamcrest.Matchers.equalTo("breed"))

                // attributes
                .body("data.attributes.name", org.hamcrest.Matchers.equalTo("Akita"))

                .body("data.attributes.life.min", org.hamcrest.Matchers.equalTo(10))
                .body("data.attributes.life.max", org.hamcrest.Matchers.equalTo(12))

                .body("data.attributes.male_weight.min", org.hamcrest.Matchers.equalTo(35))
                .body("data.attributes.male_weight.max", org.hamcrest.Matchers.equalTo(60))

                .body("data.attributes.female_weight.min", org.hamcrest.Matchers.equalTo(35))
                .body("data.attributes.female_weight.max", org.hamcrest.Matchers.equalTo(50))

                .body("data.attributes.description",
                        org.hamcrest.Matchers.equalTo("The Akita is a large, muscular dog breed that originated in Japan. They are known for their loyalty and courage."))

                .body("data.attributes.hypoallergenic", org.hamcrest.Matchers.equalTo(false))

                // links
                .body("links.self",
                        org.hamcrest.Matchers.equalTo("https://dogapi.dog/api/v2/breeds/e7e99424-d514-4b56-9f0c-05736f6dd22d"))

                // extra validations
                .body("data", notNullValue())
                .body("data.attributes", notNullValue());

    }
}