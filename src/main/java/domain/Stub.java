package domain;

import java.util.List;

public class Stub<T>{
    private List<T> responses;

    public Stub(List<T> httpResponse) {
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
