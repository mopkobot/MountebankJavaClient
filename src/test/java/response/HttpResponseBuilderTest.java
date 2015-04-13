package response;

import org.junit.Before;
import org.junit.Test;
import responses.HttpResponse;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HttpResponseBuilderTest {

    private HttpResponseBuilder responseBuilder;

    @Before
    public void setUp() throws Exception {
        responseBuilder = new HttpResponseBuilder();
    }

    @Test
    public void shouldCreateAResponseWithStatusCode200() {
        HttpResponse httpResponse = responseBuilder.withStatusCode("200").build();

        assertThat(httpResponse.getStatusCode().get(), is("200"));
    }

    @Test
    public void shouldCreateAResponseWithEmptyStatusCodeIfPassedInStatusCodeIsEmptyString() {
        HttpResponse httpResponse = responseBuilder.withStatusCode("").build();

        assertThat(httpResponse.getStatusCode().isPresent(), is(false));
    }

    @Test
    public void shouldCreateAResponseWithStatusBody() {
        HttpResponse httpResponse = responseBuilder.withBody("Example Body").build();

        assertThat(httpResponse.getBody().get(), is("Example Body"));
    }

    @Test
    public void shouldCreateAResponseWithEmptyBodyIfPassedInBodyIsEmptyString() {
        HttpResponse httpResponse = responseBuilder.withBody("").build();

        assertThat(httpResponse.getBody().isPresent(), is(false));
    }

    @Test
    public void shouldCreateAResponseWithHeaders() {
        Map<String, String> mapOfHeaders = newHashMap();
        mapOfHeaders.put("Location", "http://localhost:4545/customers/123");

        HttpResponse httpResponse = responseBuilder.withHeaders(mapOfHeaders).build();

        assertThat(httpResponse.getHeaders().get(), is(mapOfHeaders));
    }

    @Test
    public void shouldCreateAResponseWithEmptyHeadersIfPassedInHeadersIsEmptyMap() {
        HashMap<String, String> emptyHeaders = newHashMap();
        HttpResponse httpResponse = responseBuilder.withHeaders(emptyHeaders).build();

        assertThat(httpResponse.getBody().isPresent(), is(false));
    }
}
