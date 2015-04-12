package response;

import responses.HttpResponse;

import java.util.Map;

public class ResponseBuilder {
    private String statusCode;
    private String body;
    private Map<String, String> mapOfHeaders;

    public ResponseBuilder withStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ResponseBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public ResponseBuilder withHeaders(Map<String, String> mapOfHeaders) {
        this.mapOfHeaders = mapOfHeaders;
        return this;
    }

    public HttpResponse build() {
        return new HttpResponse(statusCode, body, mapOfHeaders);
    }
}
