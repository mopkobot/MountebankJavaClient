package serializer;

import com.google.common.base.Optional;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import domain.HttpResponse;

import java.lang.reflect.Type;
import java.util.Map;

import static java.lang.Integer.valueOf;

public class ResponseJsonSerializer implements JsonSerializer<HttpResponse> {
    @Override
    public JsonElement serialize(HttpResponse httpResponse, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        JsonObject responseInner = new JsonObject();

        addStatusCodeToResponse(httpResponse, responseInner);
        addBodyToResponse(httpResponse, responseInner);
        addHeadersToResponse(httpResponse, responseInner);

        object.add("is", responseInner);
        return object;
    }

    private void addHeadersToResponse(HttpResponse httpResponse, JsonObject responseInner) {
        if (httpResponse.getHeaders().isPresent()) {
            JsonObject headers = new JsonObject();
            for (Map.Entry<String, String> headerSet : httpResponse.getHeaders().get().entrySet()) {
                headers.addProperty(headerSet.getKey(), headerSet.getValue());
            }
            responseInner.add("headers", headers);
        }
    }

    private void addBodyToResponse(HttpResponse httpResponse, JsonObject responseInner) {
        Optional<String> optionalBody = httpResponse.getBody();
        if (optionalBody.isPresent()) {
            responseInner.addProperty("body", optionalBody.get());
        }
    }

    private void addStatusCodeToResponse(HttpResponse httpResponse, JsonObject responseInner) {
        Optional<String> statusCode = httpResponse.getStatusCode();
        if (statusCode.isPresent()) {
            responseInner.addProperty("statusCode", valueOf(statusCode.get()));
        }
    }
}
