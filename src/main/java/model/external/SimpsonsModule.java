package model.external;

import lombok.Getter;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class SimpsonsModule {

    private static SimpsonsModule instance;

    private static final String BASE_URL = "https://thesimpsonsquoteapi.glitch.me/";
    private final Retrofit retrofitAPI = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();
    private final SimpsonsAPI simpsonsAPI = retrofitAPI.create(SimpsonsAPI.class);
    private final SimpsonsToQuoteResolver simpsonsToQuoteResolver = new JsonSimpsonsToQuoteResolverImpl();
    @Getter
    private final SimpsonsService simpsonsService = new SimpsonsServiceImpl(simpsonsAPI, simpsonsToQuoteResolver);

    private SimpsonsModule() {}

    public static SimpsonsModule getInstance() {
        if (instance == null) {
            instance = new SimpsonsModule();
        }
        return instance;
    }


}
