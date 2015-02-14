package domain;

public class Response {
    private String statusCode;

    public Response(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
