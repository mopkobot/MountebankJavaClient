package imposterFactory;

import domain.Imposter;
import domain.TypeOfRequest;

import static domain.TypeOfRequest.*;

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

    private Imposter createImposter(TypeOfRequest protocol, Integer port) {
        return new Imposter(protocol, port);
    }
}
