package imposterFactory;

import domain.HttpProtocol;
import domain.Imposter;

import static domain.HttpProtocol.*;

public class ImposterFactory {
    public Imposter createHttpImposter(Integer port) {
        return createImposter(HTTP, port);
    }

    public Imposter createHttpsImposter(Integer port) {
        return createImposter(HTTPS, port);
    }

    public Imposter createSmtpImposter(Integer port) {
        return createImposter(SMTP, port);
    }

    public Imposter createTCPImposter(Integer port) {
        return createImposter(TCP, port);
    }

    private Imposter createImposter(HttpProtocol protocol, Integer port) {
        return new Imposter(protocol, port);
    }
}
