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
        List<Response> responses = newArrayList(mock(Response.class));
        Stub stubOne = new Stub(responses);
        Stub stubTwo = new Stub(responses);

        assertThat(stubOne, is(stubTwo));
    }

    @Test
    public void twoStubsShouldBeNotEqualIfTheResponsesAreDifferent() {
        List<Response> responseOne = newArrayList(mock(Response.class));
        List<Response> responseTwo = newArrayList(mock(Response.class));
        Stub stubOne = new Stub(responseOne);
        Stub stubTwo = new Stub(responseTwo);

        assertThat(stubOne, is(not((stubTwo))));
    }

}