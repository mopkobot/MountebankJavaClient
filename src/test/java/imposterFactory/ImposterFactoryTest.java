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
        Imposter imposter = imposterFactory.createHttpImposter("");

        assertThat(imposter.getProtocol(), is("http"));
    }

    @Test
    public void shouldCreateHttpsImposter() {
        Imposter imposter = imposterFactory.createHttpsImposter("");

        assertThat(imposter.getProtocol(), is("https"));
    }

    @Test
    public void shouldCreateSmtpImposter() {
        Imposter imposter = imposterFactory.createSmtpImposter("");

        assertThat(imposter.getProtocol(), is("smtp"));
    }

    @Test
    public void shouldCreateTcpImposter() {
        Imposter imposter = imposterFactory.createTCPImposter("");

        assertThat(imposter.getProtocol(), is("tcp"));
    }

    @Test
    public void shouldCreateImposterOnASpecificPort() {
        String port = "1234";

        Imposter imposter = imposterFactory.createTCPImposter(port);

        assertThat(imposter.getPort(), is(1234));
    }

}
