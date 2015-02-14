package response;

import domain.Response;
import org.junit.Before;
import org.junit.Test;

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

        assertThat(response.getStatusCode(), is("200"));
    }

    @Test
    public void shouldCreateAResponseWithStatusBody() {
        Response response = responseBuilder.withBody("Example Body").build();

        assertThat(response.getBody(), is("Example Body"));
    }

    @Test
    public void shouldCreateAResponseWithHeaders() {
        Map<String, String> mapOfHeaders = newHashMap();
        mapOfHeaders.put("Location", "http://localhost:4545/customers/123");

        Response response = responseBuilder.withHeaders(mapOfHeaders).build();

        assertThat(response.getHeaders(), is(mapOfHeaders));
    }

}
