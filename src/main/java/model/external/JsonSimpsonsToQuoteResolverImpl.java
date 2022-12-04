package model.external;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.entities.SimpsonsQuote;

public class JsonSimpsonsToQuoteResolverImpl implements SimpsonsToQuoteResolver {

    private static final String QUOTE = "quote";
    private static final String CHARACTER = "character";
    private JsonObject quote;

    @Override
    public SimpsonsQuote getQuoteFromExternalData(String serviceData) {
        try {
            extractJsonObject(serviceData);
            return buildSimpsonsQuote();
        } catch (Exception e) {
            return null;
        }
    }

    private void extractJsonObject(String serviceData) {
        JsonArray array = new Gson().fromJson(serviceData, JsonArray.class);
        quote = array.get(0).getAsJsonObject();
    }

    private SimpsonsQuote buildSimpsonsQuote() {
        return new SimpsonsQuote(
                getQuoteText(),
                getQuoteCharacter()
        );
    }

    private String getQuoteText() {
        return quote.get(QUOTE).getAsString();
    }

    private String getQuoteCharacter() {
        return quote.get(CHARACTER).getAsString();
    }


}
