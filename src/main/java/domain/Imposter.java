package domain;

import responses.HttpResponse;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Imposter {
    private Integer port;
    private String protocol;
    private String mode;
    private String name;
    private List<Stub> stubs = newArrayList();

    public Imposter(TypeOfRequest protocol, Integer port, String mode, String name) {
        this.name = name;
        this.protocol = protocol.getFormattedName();
        this.port = port;
        this.mode = mode;
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

    public void addResponses(List<HttpResponse> httpResponse) {
        stubs.add(new Stub(httpResponse));
    }

    public String getMode() {
        return mode;
    }

    public String getName() {
        return name;
    }
}
