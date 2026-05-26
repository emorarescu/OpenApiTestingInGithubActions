package org.example.tests;

import io.restassured.response.Response;
import org.example.api.service.BreedsApiService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BreedsTest {

    @Test
    void returnOneBreed() {
        BreedsApiService breedsApiService = new BreedsApiService();

        Response breedsResponse = breedsApiService.getBreed("dd9362cc-52e0-462d-b856-fccdcf24b140");

        assert breedsResponse.getBody().prettyPrint().contains("dd9362cc-52e0-462d-b856-fccdcf24b140");

    }

    @Test
    @Tag("valera")
    void returnBreeds() {
        BreedsApiService breedsApiService = new BreedsApiService();

        Response breedsResponse = breedsApiService.getBreeds(1, 5);
//        assert breedsResponse.getBody().as(BreedsResponse.class).getData().size() == 5;
        assert breedsResponse.getBody().prettyPrint().contains("The Affenpinscher is a small");

    }


}
