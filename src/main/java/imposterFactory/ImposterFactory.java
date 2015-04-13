package imposterFactory;

import domain.Imposter;
import response.SmtpResponse;
import response.TcpResponse;
import responses.HttpResponse;
import tcp.TcpMode;

import static com.google.common.collect.Lists.newArrayList;
import static domain.TypeOfRequest.*;
import static tcp.TcpMode.TEXT;

public class ImposterFactory {
    public Imposter createHttpImposter(Integer port, String name) {
        return new Imposter<HttpResponse>(HTTP, port, null, name);
    }

    public Imposter createHttpsImposter(Integer port, String name) {
        return new Imposter<HttpResponse>(HTTPS, port, null, name);
    }

    public Imposter createSmtpImposter(Integer port, String name) {
        return new Imposter<SmtpResponse>(SMTP, port, null, name);
    }

    public Imposter createTCPImposter(Integer port, TcpMode mode, String name) {
        if(!newArrayList(TcpMode.values()).contains(mode)) {
            return new Imposter<TcpResponse>(TCP, port, TEXT.getFormattedName(), name);
        }
        return new Imposter<TcpResponse>(TCP, port, mode.getFormattedName(), name);
    }

}
