package imposterFactory;

import domain.Imposter;
import domain.TypeOfRequest;
import tcp.TcpMode;

import static com.google.common.collect.Lists.newArrayList;
import static domain.TypeOfRequest.*;
import static tcp.TcpMode.TEXT;

public class ImposterFactory {
    public Imposter createHttpImposter(Integer port) {
        return createImposter(HTTP, port, null);
    }

    public Imposter createHttpsImposter(Integer port) {
        return createImposter(HTTPS, port, null);
    }

    public Imposter createSmtpImposter(Integer port) {
        return createImposter(SMTP, port, null);
    }

    public Imposter createTCPImposter(Integer port, TcpMode mode) {
        if(!newArrayList(TcpMode.values()).contains(mode)) {
            return createImposter(TCP, port, TEXT.getFormattedName());
        }
        return createImposter(TCP, port, mode.getFormattedName());
    }

    private Imposter createImposter(TypeOfRequest protocol, Integer port, String mode) {
        return new Imposter(protocol, port, mode);
    }
}
