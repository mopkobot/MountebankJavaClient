package domain;

import com.google.common.base.Optional;

import java.util.Map;

import static com.google.common.base.Optional.absent;
import static com.google.common.base.Optional.fromNullable;

public class HttpResponse {
    private String statusCode;
    private String body;
    private Map<String, String> headers;

    public HttpResponse(String statusCode, String body, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }

    public Optional<String> getStatusCode() {
        Optional<String> optionalStatusCode = fromNullable(statusCode);
        if (optionalStatusCode.isPresent() && optionalStatusCode.get().isEmpty()) {
            return absent();
        }
        return optionalStatusCode;
    }

    public Optional<String> getBody() {
        Optional<String> optionalBody = fromNullable(body);
        if (optionalBody.isPresent() && optionalBody.get().isEmpty()) {
            return absent();
        }
        return optionalBody;
    }

    public Optional<Map<String, String>> getHeaders() {
        Optional<Map<String, String>> optionalHeaders = fromNullable(headers);
        if (optionalHeaders.isPresent() && optionalHeaders.get().isEmpty()) {
            return absent();
        }
        return optionalHeaders;
    }
}
