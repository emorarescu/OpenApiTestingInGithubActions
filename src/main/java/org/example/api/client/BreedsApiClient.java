package org.example.api.client;

import io.restassured.response.Response;
import org.example.api.RestApiClientBuilder;
import org.openapitools.client.api.BreedsApi;

import java.util.function.Function;

public class BreedsApiClient {

    private final BreedsApi breedsApi = new RestApiClientBuilder().build(BreedsApi::breeds);

    public Response queryBreed(String id) {
        return breedsApi.breedsIdGet().idPath(id).execute(Function.identity());
    }

    public Response queryBreeds(Integer pageNumber, Integer pageSize) {
        return breedsApi.breedsGet().pageNumberQuery(pageNumber).pageSizeQuery(pageSize).execute(Function.identity());
    }
}
