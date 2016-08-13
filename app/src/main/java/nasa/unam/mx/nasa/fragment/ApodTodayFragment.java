package nasa.unam.mx.nasa.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.data.Data;
import nasa.unam.mx.nasa.model.Apod;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApodTodayFragment extends ApodTodayFragmentAMO
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.activity_main, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        init_today_apod();
    }
}
