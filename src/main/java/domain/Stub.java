package domain;

import java.util.List;

public class Stub{
    private List<Response> responses;

    public Stub(List<Response> response) {
        this.responses = response;
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
