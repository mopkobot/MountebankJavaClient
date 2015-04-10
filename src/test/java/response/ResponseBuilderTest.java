package response;

import domain.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResponseBuilderTest {

    private ResponseBuilder responseBuilder;

    @Before
    public void setUp() throws Exception {
        responseBuilder = new ResponseBuilder();
    }

    @Test
    public void shouldCreateAResponseWithStatusCode200() {
        Response response = responseBuilder.withStatusCode("200").build();

        assertThat(response.getStatusCode().get(), is("200"));
    }

    @Test
    public void shouldCreateAResponseWithEmptyStatusCodeIfPassedInStatusCodeIsEmptyString() {
        Response response = responseBuilder.withStatusCode("").build();

        assertThat(response.getStatusCode().isPresent(), is(false));
    }

    @Test
    public void shouldCreateAResponseWithStatusBody() {
        Response response = responseBuilder.withBody("Example Body").build();

        assertThat(response.getBody().get(), is("Example Body"));
    }

    @Test
    public void shouldCreateAResponseWithEmptyBodyIfPassedInBodyIsEmptyString() {
        Response response = responseBuilder.withBody("").build();

        assertThat(response.getBody().isPresent(), is(false));
    }

    @Test
    public void shouldCreateAResponseWithHeaders() {
        Map<String, String> mapOfHeaders = newHashMap();
        mapOfHeaders.put("Location", "http://localhost:4545/customers/123");

        Response response = responseBuilder.withHeaders(mapOfHeaders).build();

        assertThat(response.getHeaders().get(), is(mapOfHeaders));
    }

    @Test
    public void shouldCreateAResponseWithEmptyHeadersIfPassedInHeadersIsEmptyMap() {
        HashMap<String, String> emptyHeaders = newHashMap();
        Response response = responseBuilder.withHeaders(emptyHeaders).build();

        assertThat(response.getBody().isPresent(), is(false));
    }
}
