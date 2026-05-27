package org.example.tests;

import io.restassured.response.Response;
import org.example.api.service.BreedsApiService;

public class BreedsTest {

//    @Test
//    @Tag("test1")
    void returnOneBreed() {
        BreedsApiService breedsApiService = new BreedsApiService();

        Response breedsResponse = breedsApiService.getBreed("dd9362cc-52e0-462d-b856-fccdcf24b140");

        assert breedsResponse.getBody().prettyPrint().contains("dd9362cc-52e0-462d-b856-fccdcf24b140");

    }

//    @Test
//    @Tag("test2")
    void returnBreeds() {
        BreedsApiService breedsApiService = new BreedsApiService();

        Response breedsResponse = breedsApiService.getBreeds(1, 5);
//        assert breedsResponse.getBody().as(BreedsResponse.class).getData().size() == 5;
        assert breedsResponse.getBody().prettyPrint().contains("The Affenpinscher is a small");

    }


}
