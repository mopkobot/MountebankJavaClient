package domain;

import org.junit.Test;
import responses.HttpResponse;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ImposterTest {

    @Test
    public void shouldCreateAStubThatContainsTheAddedResponse() {
        Imposter imposter = new Imposter(TypeOfRequest.HTTP, null, null, null);
        List<HttpResponse> httpResponse = newArrayList(mock(HttpResponse.class));

        imposter.addResponses(httpResponse);

        assertThat(imposter.getStubs(), contains(new Stub(httpResponse)));
    }



}