package response;

import responses.HttpResponse;

import java.util.Map;

public class HttpResponseBuilder {
    private String statusCode;
    private String body;
    private Map<String, String> mapOfHeaders;

    public HttpResponseBuilder withStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public HttpResponseBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public HttpResponseBuilder withHeaders(Map<String, String> mapOfHeaders) {
        this.mapOfHeaders = mapOfHeaders;
        return this;
    }

    public HttpResponse build() {
        return new HttpResponse(statusCode, body, mapOfHeaders);
    }
}
