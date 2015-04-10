package domain;

import com.google.common.base.Optional;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Map;

import static java.lang.Integer.valueOf;

public class ResponseJsonSerializer implements JsonSerializer<Response> {
    @Override
    public JsonElement serialize(Response response, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        JsonObject responseInner = new JsonObject();

        addStatusCodeToResponse(response, responseInner);
        addBodyToResponse(response, responseInner);
        addHeadersToResponse(response, responseInner);

        object.add("is", responseInner);
        return object;
    }

    private void addHeadersToResponse(Response response, JsonObject responseInner) {
        if (response.getHeaders().isPresent()) {
            JsonObject headers = new JsonObject();
            for (Map.Entry<String, String> headerSet : response.getHeaders().get().entrySet()) {
                headers.addProperty(headerSet.getKey(), headerSet.getValue());
            }
            responseInner.add("headers", headers);
        }
    }

    private void addBodyToResponse(Response response, JsonObject responseInner) {
        Optional<String> optionalBody = response.getBody();
        if (optionalBody.isPresent()) {
            responseInner.addProperty("body", optionalBody.get());
        }
    }

    private void addStatusCodeToResponse(Response response, JsonObject responseInner) {
        Optional<String> statusCode = response.getStatusCode();
        if (statusCode.isPresent()) {
            responseInner.addProperty("statusCode", valueOf(statusCode.get()));
        }
    }
}
