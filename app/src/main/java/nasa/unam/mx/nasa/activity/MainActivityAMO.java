package nasa.unam.mx.nasa.activity;

import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import nasa.unam.mx.nasa.BuildConfig;
import nasa.unam.mx.nasa.adapter.NasaApodAdapter;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.data.Data;
import nasa.unam.mx.nasa.model.Apod;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import nasa.unam.mx.nasa.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class MainActivityAMO extends MainActivityDMO
{
    protected void init_flavor(String activity_name)
    {
        sb = new StringBuilder();
        sb.append("FLAVOR :: ").append(BuildConfig.FLAVOR).append(" :: ");
        sb.append("   URL :: ").append(BuildConfig.URL);

        Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
        Log.d(activity_name + " :: ", sb.toString());

    }

    protected void init_today_apod()
    {
        service = Data.getInstance().create(ApodServiceIMO.class);

        request = service.getTodayApod();
        //request = service.getTodayApodWithQuery("TlWYgKkzBKK2KmrIeFzKyS83hRml1pWhCmG7oqRH");

        request.enqueue(new Callback<Apod>()
        {
            @Override
            public void onResponse(Call<Apod> call, Response<Apod> response)
            {
    /*
                    txt_date.setText(response.body().getDate());
                    txt_title.setText(response.body().getTitle());
                    txt_explanation.setText(response.body().getExplanation());

                    String url = response.body().getUrl();

                    Picasso.with(getApplicationContext()).load(url).into(image_view);
    */
            }

            @Override
            public void onFailure(Call<Apod> call, Throwable t) {

            }
        });
    }

    protected void init_mars_rover_photos()
    {
        //manager = new LinearLayoutManager(this);
        manager = new GridLayoutManager(this, 2);
        recycler_view.setLayoutManager(manager);
        //recycler_view.setit

        request_mars_rover = service.getMarsRoverPhotos();

        request_mars_rover.enqueue(new Callback<MarsRoverResponse>()
        {
            @Override
            public void onResponse(Call<MarsRoverResponse> call, Response<MarsRoverResponse> response)
            {
                List<Photo> photos = response.body().getPhotos();

                adapter = new NasaApodAdapter(photos);
                recycler_view.setAdapter(adapter);

                for(Photo photo : photos)
                {
                    Log.d("APOD", "photo.getImgSrc(): " + photo.getImgSrc());
                }
            }

            @Override
            public void onFailure(Call<MarsRoverResponse> call, Throwable t)
            {

            }
        });
    }
}