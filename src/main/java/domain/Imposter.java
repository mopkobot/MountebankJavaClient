package domain;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Imposter<T> {
    private Integer port;
    private String protocol;
    private String mode;
    private String name;
    private List<Stub<T>> stubs = newArrayList();

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

    public List<Stub<T>> getStubs() {
        return stubs;
    }

    public void addResponses(List<T> httpResponse) {
        stubs.add(new Stub<T>(httpResponse));
    }

    public String getMode() {
        return mode;
    }

    public String getName() {
        return name;
    }
}
