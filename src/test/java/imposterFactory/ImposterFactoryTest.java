package imposterFactory;

import domain.Imposter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ImposterFactoryTest {

    private ImposterFactory imposterFactory;

    @Before
    public void setUp() throws Exception {
        imposterFactory = new ImposterFactory();
    }

    @Test
    public void shouldCreateHttpImposter() {
        Imposter imposter = imposterFactory.createHttpImposter(null);

        assertThat(imposter.getProtocol(), is("http"));
    }

    @Test
    public void shouldCreateHttpsImposter() {
        Imposter imposter = imposterFactory.createHttpsImposter(null);

        assertThat(imposter.getProtocol(), is("https"));
    }

    @Test
    public void shouldCreateSmtpImposter() {
        Imposter imposter = imposterFactory.createSmtpImposter(null);

        assertThat(imposter.getProtocol(), is("smtp"));
    }

    @Test
    public void shouldCreateTcpImposter() {
        Imposter imposter = imposterFactory.createTCPImposter(null);

        assertThat(imposter.getProtocol(), is("tcp"));
    }

    @Test
    public void shouldCreateImposterOnASpecificPort() {
        Integer port = 1234;

        Imposter imposter = imposterFactory.createTCPImposter(port);

        assertThat(imposter.getPort(), is(port));
    }

}
