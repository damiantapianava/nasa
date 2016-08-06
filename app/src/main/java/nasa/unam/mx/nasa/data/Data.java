package nasa.unam.mx.nasa.data;

import nasa.unam.mx.nasa.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alumno on 30/07/2016.
 */
public class Data
{
    public static Retrofit getInstance()
    {
        HttpLoggingInterceptor interceptor;
        OkHttpClient.Builder client;
        Retrofit builder;

        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        builder = new Retrofit.Builder().baseUrl(BuildConfig.URL)
                .addConverterFactory(GsonConverterFactory.create()) //puede omitirse y leer el String JSON
                .client(client.build()) //Se agrega el log que aparece al realizar los enqueue
                .build();

        return builder;
    }
}
