package nasa.unam.mx.nasa.fragment;

import com.squareup.picasso.Picasso;

import nasa.unam.mx.nasa.app.ApodPreference;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.data.Data;
import nasa.unam.mx.nasa.model.Apod;
import nasa.unam.mx.nasa.model.ApodFavorite;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApodTodayFragmentAMO extends ApodTodayFragmentDMO
{
    public void init_today_apod()
    {
        service = Data.getInstance().create(ApodServiceIMO.class);

        request = service.getTodayApod();
        //request = service.getTodayApodWithQuery("TlWYgKkzBKK2KmrIeFzKyS83hRml1pWhCmG7oqRH");

        request.enqueue(new Callback<Apod>()
        {
            @Override
            public void onResponse(Call<Apod> call, Response<Apod> response)
            {
                txt_date.setText(response.body().getDate());
                txt_title.setText(response.body().getTitle());
                txt_explanation.setText(response.body().getExplanation());

                String url = response.body().getUrl();

                Picasso.with(getActivity()).load(url).into(image_view);

                favorite = new ApodFavorite();
                favorite.setImgSrc(url);
                favorite.setEarthDate(response.body().getDate());
                favorite.setCameraFullName(response.body().getTitle());
                favorite.setRoverName(response.body().getExplanation());

                preference = new ApodPreference(getActivity());
                preference.setApodFavorite(favorite);
            }

            @Override
            public void onFailure(Call<Apod> call, Throwable t)
            {

            }
        });
    }
}
