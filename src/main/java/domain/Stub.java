package domain;

import responses.HttpResponse;

import java.util.List;

public class Stub{
    private List<HttpResponse> responses;

    public Stub(List<HttpResponse> httpResponse) {
        this.responses = httpResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stub stub = (Stub) o;

        if (responses != null ? !responses.equals(stub.responses) : stub.responses != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return responses != null ? responses.hashCode() : 0;
    }
}
