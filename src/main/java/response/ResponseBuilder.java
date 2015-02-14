package response;

import domain.Response;

public class ResponseBuilder {
    private String statusCode;

    public ResponseBuilder withStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Response build() {
        return new Response(statusCode);
    }
}
