package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Response;
import org.junit.Test;

import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResponseJsonSerializerTest {
    @Test
    public void shouldTransformResponseIntoACustomJsonObjectContainingStatusCode() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        Response response = new Response("200", null, null);

        assertThat(gson.toJson(response), is("{\"is\":{\"statusCode\":200}}"));
    }

    @Test
    public void shouldTransformIntoEmptyObjectWhenStatusCodeIsNull() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        Response response = new Response(null, null, null);

        assertThat(gson.toJson(response), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformIntoEmptyObjectWhenStatusCodeIsEmptyString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        Response response = new Response("", null, null);

        assertThat(gson.toJson(response), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoACustomJsonObjectContainingBody() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        Response response = new Response(null, "ALEKS", null);

        assertThat(gson.toJson(response), is("{\"is\":{\"body\":\"ALEKS\"}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenBodyIsNull() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        Response response = new Response(null, null, null);

        assertThat(gson.toJson(response), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenBodyIsEmptyString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        Response response = new Response(null, "", null);

        assertThat(gson.toJson(response), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoACustomJsonObjectContainingHeaders() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();
        HashMap<String, String> headers = newHashMap();
        headers.put("Content-Type", "application/json");

        Response response = new Response(null, null, headers);

        assertThat(gson.toJson(response), is("{\"is\":{" +
                "\"headers\":{" +
                "\"Content-Type\":\"application/json\"" +
                "}" +
                "}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenHeadersMapIsNull() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        Response response = new Response(null, null, null);

        assertThat(gson.toJson(response), is("{\"is\":{}}"));
    }

    @Test
    public void shouldTransformResponseIntoAnEmptyJsonObjectWhenHeadersMapIsEmpty() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Response.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();
        HashMap<String, String> emptyHeadersMap = newHashMap();

        Response response = new Response(null, null, emptyHeadersMap);

        assertThat(gson.toJson(response), is("{\"is\":{}}"));
    }
}
