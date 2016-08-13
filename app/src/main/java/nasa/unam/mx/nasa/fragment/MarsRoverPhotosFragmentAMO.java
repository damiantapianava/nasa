package nasa.unam.mx.nasa.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import java.util.List;

import nasa.unam.mx.nasa.activity.DetailActivity;
import nasa.unam.mx.nasa.adapter.NasaApodAdapter;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.data.Data;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import nasa.unam.mx.nasa.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class MarsRoverPhotosFragmentAMO extends MarsRoverPhotosFragmentDMO
{
    protected void init_adapter()
    {
        manager = new GridLayoutManager(getActivity(), 2);
        recycler_view.setLayoutManager(manager);

        adapter = new NasaApodAdapter();

        adapter.setOnItemClickListener(new NasaApodAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(Photo photo)
            {
                Log.d("APOD", photo.getImgSrc());

                intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("photo", photo);

                startActivity(intent);
            }
        });
    }

    protected void init_mars_rover_photos()
    {
        service = Data.getInstance().create(ApodServiceIMO.class);

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
