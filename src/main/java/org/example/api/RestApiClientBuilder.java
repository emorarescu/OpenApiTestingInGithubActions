package org.example.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import java.util.function.Function;
import java.util.function.Supplier;

public class RestApiClientBuilder {

    public <T> T build(Function<Supplier<RequestSpecBuilder>, T> clientCreator) {

        Supplier<RequestSpecBuilder> requestSpecBuilderSupplier = () ->
                new RequestSpecBuilder()
                        .addRequestSpecification(
                                new RequestSpecBuilder()
                                        .setBaseUri("https://dogapi.dog/api/v2/")
//                                        .setContentType(ContentType.JSON)
                                        .build()
                        );

        return clientCreator.apply(requestSpecBuilderSupplier);
    }
}
