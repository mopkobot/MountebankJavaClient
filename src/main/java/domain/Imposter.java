package domain;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.valueOf;

public class Imposter {
    private Integer port;
    private String protocol;
    private List<Stub> stubs = newArrayList();

    public Imposter(HttpProtocol protocol, String port) {
        this.protocol = protocol.getFormattedName();
        this.port = valueOf(port);
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public List<Stub> getStubs() {
        return stubs;
    }

    public void addResponses(List<Response> response) {
        stubs.add(new Stub(response));
    }
}
