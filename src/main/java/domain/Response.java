package domain;

import java.util.Map;

public class Response {
    private String statusCode;
    private String body;
    private Map<String, String> headers;

    public Response(String statusCode, String body, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
