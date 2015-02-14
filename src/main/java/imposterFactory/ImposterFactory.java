package imposterFactory;

import domain.HttpProtocol;
import domain.Imposter;

import static domain.HttpProtocol.*;

public class ImposterFactory {
    public Imposter createHttpImposter(String port) {
        return createImposter(HTTP, port);
    }

    public Imposter createHttpsImposter(String port) {
        return createImposter(HTTPS, port);
    }

    public Imposter createSmtpImposter(String port) {
        return createImposter(SMTP, port);
    }

    public Imposter createTCPImposter(String port) {
        return createImposter(TCP, port);
    }

    private Imposter createImposter(HttpProtocol protocol, String port) {
        return new Imposter(protocol, port);
    }
}
