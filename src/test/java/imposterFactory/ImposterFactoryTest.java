package imposterFactory;

import domain.Imposter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static tcp.TcpMode.BINARY;
import static tcp.TcpMode.TEXT;

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
        Imposter imposter = imposterFactory.createTCPImposter(null, null);

        assertThat(imposter.getProtocol(), is("tcp"));
    }

    @Test
    public void shouldCreateTcpImposterWithTextMode() {
        Imposter imposter = imposterFactory.createTCPImposter(null, TEXT);

        assertThat(imposter.getMode(), is("text"));
    }

    @Test
    public void shouldCreateTcpImposterWithBinaryMode() {
        Imposter imposter = imposterFactory.createTCPImposter(null, BINARY);

        assertThat(imposter.getMode(), is("binary"));
    }

    @Test
    public void shouldCreateTcpImposterWithTextModeIfNullIsPassedIn() {
        Imposter imposter = imposterFactory.createTCPImposter(null, null);

        assertThat(imposter.getMode(), is("text"));
    }

    @Test
    public void shouldCreateImposterOnASpecificPort() {
        Integer port = 1234;

        Imposter imposter = imposterFactory.createTCPImposter(port, null);

        assertThat(imposter.getPort(), is(port));
    }

}
