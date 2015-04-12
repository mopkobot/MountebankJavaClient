package integration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.HttpResponse;
import domain.Imposter;
import imposterFactory.ImposterFactory;
import org.junit.Test;
import response.ResponseBuilder;
import serializer.ResponseJsonSerializer;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SerializeTest {

    @Test
    public void shouldReturnJsonOfAnImposter() {
        Imposter imposter = new ImposterFactory().createHttpImposter(4545);
        Map<String, String> newHashMap = new HashMap<String, String>();
        newHashMap.put("Location", "https://location.com");
        imposter.addResponses(newArrayList(new ResponseBuilder().withStatusCode("400").withBody("Body").withHeaders(newHashMap).build()));
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HttpResponse.class, new ResponseJsonSerializer());
        Gson gson = gsonBuilder.create();

        String result = gson.toJson(imposter);

        assertThat(result, is(
                "{" +
                    "\"port\":4545," +
                    "\"protocol\":\"http\"," +
                    "\"stubs\":[" +
                    "{" +
                        "\"responses\":" +
                            "[" +
                                "{" +
                                    "\"is\":{" +
                                        "\"statusCode\":400," +
                                        "\"body\":\"Body\"," +
                                        "\"headers\":{" +
                                            "\"Location\":\"https://location.com\"" +
                                        "}" +
                                    "}" +
                                "}" +
                            "]" +
                        "}" +
                    "]" +
                "}"));
    }
}
