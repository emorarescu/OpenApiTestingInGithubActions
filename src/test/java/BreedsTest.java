import io.restassured.response.Response;
import org.example.api.service.BreedsApiService;
import org.junit.jupiter.api.Test;
import org.openapitools.client.model.BreedsResponse;

public class BreedsTest {

    @Test
    void returnOneBreed() {
        BreedsApiService breedsApiService = new BreedsApiService();

        Response breedsResponse = breedsApiService.getBreed("dd9362cc-52e0-462d-b856-fccdcf24b140");
        assert breedsResponse.getBody().prettyPrint().contains("dd9362cc-52e0-462d-b856-fccdcf24b140");

    }

    @Test
    void returnBreeds() {
        BreedsApiService breedsApiService = new BreedsApiService();

        Response breedsResponse = breedsApiService.getBreeds(1, 5);
        assert breedsResponse.getBody().as(BreedsResponse.class).getData().size() == 5;

    }
}
