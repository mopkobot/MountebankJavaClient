package imposterFactory;

import domain.Imposter;
import domain.TypeOfRequest;
import tcp.TcpMode;

import static com.google.common.collect.Lists.newArrayList;
import static domain.TypeOfRequest.*;
import static tcp.TcpMode.TEXT;

public class ImposterFactory {
    public Imposter createHttpImposter(Integer port, String name) {
        return createImposter(HTTP, port, null, name);
    }

    public Imposter createHttpsImposter(Integer port, String name) {
        return createImposter(HTTPS, port, null, name);
    }

    public Imposter createSmtpImposter(Integer port, String name) {
        return createImposter(SMTP, port, null, name);
    }

    public Imposter createTCPImposter(Integer port, TcpMode mode, String name) {
        if(!newArrayList(TcpMode.values()).contains(mode)) {
            return createImposter(TCP, port, TEXT.getFormattedName(), name);
        }
        return createImposter(TCP, port, mode.getFormattedName(), name);
    }

    private Imposter createImposter(TypeOfRequest protocol, Integer port, String mode, String name) {
        return new Imposter(protocol, port, mode, name);
    }
}
