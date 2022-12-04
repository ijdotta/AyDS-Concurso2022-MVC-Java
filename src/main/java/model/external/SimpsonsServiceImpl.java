package model.external;

import lombok.AllArgsConstructor;
import model.entities.SimpsonsQuote;
import retrofit2.Response;

import java.io.IOException;

@AllArgsConstructor
public class SimpsonsServiceImpl implements SimpsonsService {

    private SimpsonsAPI simpsonsAPI;
    private SimpsonsToQuoteResolver simpsonsToQuoteResolver;

    @Override
    public SimpsonsQuote getQuote() {
        Response<String> response;
        try {
            response = getQuoteFromService();
        } catch (IOException e) {
            return null;
        }
        return simpsonsToQuoteResolver.getQuoteFromExternalData(response.body());
    }

    private Response<String> getQuoteFromService() throws IOException {
        return simpsonsAPI.getRandomQuote().execute();
    }
}
