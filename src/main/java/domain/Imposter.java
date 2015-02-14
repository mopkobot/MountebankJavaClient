package domain;

public class Imposter {
    private HttpProtocol protocol;
    private String port;

    public Imposter(HttpProtocol protocol, String port) {
        this.protocol = protocol;
        this.port = port;
    }

    public HttpProtocol getProtocol() {
        return protocol;
    }

    public String getPort() {
        return port;
    }
}
