package nasa.unam.mx.nasa;

import nasa.unam.mx.nasa.model.Apod;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApodServiceIMO
{
    @GET("planetary/apod?api_key=TlWYgKkzBKK2KmrIeFzKyS83hRml1pWhCmG7oqRH")
    Call<Apod> getTodayApod();

    @GET("planetary/apod")
    Call<Apod> getTodayApodWithQuery(@Query("api_key") String apiKey);

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=20&api_key=TlWYgKkzBKK2KmrIeFzKyS83hRml1pWhCmG7oqRH")
    Call<MarsRoverResponse> getMarsRoverPhotos();
}
