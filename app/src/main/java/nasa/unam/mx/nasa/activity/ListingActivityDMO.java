package nasa.unam.mx.nasa.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.adapter.NasaApodAdapterDMO;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import retrofit2.Call;

public abstract class ListingActivityDMO extends AppCompatActivity
{
    @BindView(R.id.recycler_view)
    protected RecyclerView recycler_view;

    protected ApodServiceIMO service;

    protected RecyclerView.LayoutManager manager;

    //protected RecyclerView.Adapter adapter;
    protected NasaApodAdapterDMO adapter;

    protected Intent intent;

    protected Call<MarsRoverResponse> request_mars_rover;
}
