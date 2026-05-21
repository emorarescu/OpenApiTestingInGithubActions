package org.example.api.service;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.api.client.BreedsApiClient;

public class BreedsApiService {

    private final BreedsApiClient breedsApiClient = new BreedsApiClient();

    public Response getBreed(String id) {
        return breedsApiClient.queryBreed(id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public Response getBreeds(Integer pageNumber, Integer pageSize) {
        return breedsApiClient.queryBreeds(pageNumber, pageSize)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

}
