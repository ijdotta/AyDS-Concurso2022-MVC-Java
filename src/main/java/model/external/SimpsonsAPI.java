package model.external;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SimpsonsAPI {
    @GET("quotes")
    Call<String> getRandomQuote();
}
