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
    public void shouldCreateHttpImposterWithName() {
        Imposter imposter = imposterFactory.createHttpImposter(null, "name");

        assertThat(imposter.getProtocol(), is("http"));
        assertThat(imposter.getName(), is("name"));
    }

    @Test
    public void shouldCreateHttpsImposterWithName() {
        Imposter imposter = imposterFactory.createHttpsImposter(null, "name");

        assertThat(imposter.getProtocol(), is("https"));
        assertThat(imposter.getName(), is("name"));
    }

    @Test
    public void shouldCreateSmtpImposter() {
        Imposter imposter = imposterFactory.createSmtpImposter(null, "name");

        assertThat(imposter.getProtocol(), is("smtp"));
        assertThat(imposter.getName(), is("name"));
    }

    @Test
    public void shouldCreateTcpImposter() {
        Imposter imposter = imposterFactory.createTCPImposter(null, null, "name");

        assertThat(imposter.getProtocol(), is("tcp"));
        assertThat(imposter.getName(), is("name"));
    }

    @Test
    public void shouldCreateTcpImposterWithTextMode() {
        Imposter imposter = imposterFactory.createTCPImposter(null, TEXT, null);

        assertThat(imposter.getMode(), is("text"));
    }

    @Test
    public void shouldCreateTcpImposterWithBinaryMode() {
        Imposter imposter = imposterFactory.createTCPImposter(null, BINARY, null);

        assertThat(imposter.getMode(), is("binary"));
    }

    @Test
    public void shouldCreateTcpImposterWithTextModeIfNullIsPassedIn() {
        Imposter imposter = imposterFactory.createTCPImposter(null, null, null);

        assertThat(imposter.getMode(), is("text"));
    }

    @Test
    public void shouldCreateImposterOnASpecificPort() {
        Integer port = 1234;

        Imposter imposter = imposterFactory.createTCPImposter(port, null, null);

        assertThat(imposter.getPort(), is(port));
    }

}
