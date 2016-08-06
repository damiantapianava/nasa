package nasa.unam.mx.nasa.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.model.Apod;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import retrofit2.Call;

public abstract class MainActivityDMO extends AppCompatActivity
{
/*
    @BindView(R.id.iv_app_ic)
    protected ImageView image_view;

    @BindView(R.id.txt_title)
    protected TextView txt_title;

    @BindView(R.id.txt_date)
    protected TextView txt_date;

    @BindView(R.id.txt_explanation)
    protected TextView txt_explanation;
*/

    @BindView(R.id.recycler_view)
    protected RecyclerView recycler_view;

    protected RecyclerView.LayoutManager manager;
    protected RecyclerView.Adapter adapter;

    protected ApodServiceIMO service;

    protected Call<Apod> request;
    protected Call<MarsRoverResponse> request_mars_rover;

    protected StringBuilder sb;
}
