package nasa.unam.mx.nasa.activity;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import java.util.List;

import nasa.unam.mx.nasa.adapter.NasaApodAdapter;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import nasa.unam.mx.nasa.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ListingActivityAMO extends ListingActivityDMO
{
    protected void init_adapter()
    {
        //manager = new LinearLayoutManager(this);
        manager = new GridLayoutManager(this, 2);
        recycler_view.setLayoutManager(manager);
        //recycler_view.setit

        adapter = new NasaApodAdapter();

        adapter.setOnItemClickListener(new NasaApodAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(Photo photo)
            {
                Log.d("APOD", photo.getImgSrc());

                intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("photo", photo);

                startActivity(intent);
            }
        });
    }

    protected void init_mars_rover_photos()
    {
        request_mars_rover = service.getMarsRoverPhotos();

        request_mars_rover.enqueue(new Callback<MarsRoverResponse>()
        {
            @Override
            public void onResponse(Call<MarsRoverResponse> call, Response<MarsRoverResponse> response)
            {
                List<Photo> photos = response.body().getPhotos();

                adapter.setPhotos(photos);
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
