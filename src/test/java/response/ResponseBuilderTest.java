package response;

import domain.Response;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResponseBuilderTest {

    @Test
    public void shouldCreateAResponseWithStatusCode200() {
        ResponseBuilder responseBuilder = new ResponseBuilder();

        Response response = responseBuilder.withStatusCode("200").build();

        assertThat(response.getStatusCode(), is("200"));
    }

}
