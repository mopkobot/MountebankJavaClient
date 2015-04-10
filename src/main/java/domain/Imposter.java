package domain;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Imposter {
    private HttpProtocol protocol;
    private String port;
    private List<Stub> stubs = newArrayList();

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

    public List<Stub> getStubs() {
        return stubs;
    }

    public void addResponse(List<Response> response) {
        stubs.add(new Stub(response));
    }
}
