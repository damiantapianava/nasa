package nasa.unam.mx.nasa.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.adapter.NasaApodAdapterDMO;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import retrofit2.Call;

public abstract class MarsRoverPhotosFragmentDMO extends Fragment
{
    @BindView(R.id.recycler_view)
    protected RecyclerView recycler_view;

    protected RecyclerView.LayoutManager manager;

    protected NasaApodAdapterDMO adapter;

    protected ApodServiceIMO service;

    protected Call<MarsRoverResponse> request_mars_rover;

    protected View view;
    protected Intent intent;
}
