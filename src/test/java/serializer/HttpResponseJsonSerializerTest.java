package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import responses.HttpResponse;

import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HttpResponseJsonSerializerTest {
    @Test
    public void shouldTransformResponseIntoACustomJsonObjectContainingStatusCode() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        HttpResponse httpResponse = new HttpResponse("200", null, null);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{\"statusCode\":200}}"));
    }

    @Test
    public void shouldTransformIntoEmptyObjectWhenStatusCodeIsNull() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        HttpResponse httpResponse = new HttpResponse(null, null, null);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformIntoEmptyObjectWhenStatusCodeIsEmptyString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        HttpResponse httpResponse = new HttpResponse("", null, null);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoACustomJsonObjectContainingBody() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        HttpResponse httpResponse = new HttpResponse(null, "ALEKS", null);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{\"body\":\"ALEKS\"}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenBodyIsNull() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        HttpResponse httpResponse = new HttpResponse(null, null, null);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenBodyIsEmptyString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        HttpResponse httpResponse = new HttpResponse(null, "", null);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoACustomJsonObjectContainingHeaders() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();
        HashMap<String, String> headers = newHashMap();
        headers.put("Content-Type", "application/json");

        HttpResponse httpResponse = new HttpResponse(null, null, headers);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{" +
                "\"headers\":{" +
                "\"Content-Type\":\"application/json\"" +
                "}" +
                "}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenHeadersMapIsNull() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        HttpResponse httpResponse = new HttpResponse(null, null, null);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenHeadersMapIsEmpty() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();
        HashMap<String, String> emptyHeadersMap = newHashMap();

        HttpResponse httpResponse = new HttpResponse(null, null, emptyHeadersMap);

        assertThat(gson.toJson(httpResponse), is("{\"is\":{}}"));
    }
}
