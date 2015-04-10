package domain;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ImposterTest {

    @Test
    public void shouldCreateAStubThatContainsTheAddedResponse() {
        Imposter imposter = new Imposter(HttpProtocol.HTTP, "");
        List<Response> response = newArrayList(mock(Response.class));

        imposter.addResponse(response);

        assertThat(imposter.getStubs(), contains(new Stub(response)));
    }



}