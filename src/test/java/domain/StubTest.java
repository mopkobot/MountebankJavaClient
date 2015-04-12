package domain;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class StubTest {

    @Test
    public void twoStubsShouldBeEqualBasedOnResponseTheyContain() {
        List<HttpResponse> httpResponses = newArrayList(mock(HttpResponse.class));
        Stub stubOne = new Stub(httpResponses);
        Stub stubTwo = new Stub(httpResponses);

        assertThat(stubOne, is(stubTwo));
    }

    @Test
    public void twoStubsShouldBeNotEqualIfTheResponsesAreDifferent() {
        List<HttpResponse> httpResponseOne = newArrayList(mock(HttpResponse.class));
        List<HttpResponse> httpResponseTwo = newArrayList(mock(HttpResponse.class));
        Stub stubOne = new Stub(httpResponseOne);
        Stub stubTwo = new Stub(httpResponseTwo);

        assertThat(stubOne, is(not((stubTwo))));
    }

}