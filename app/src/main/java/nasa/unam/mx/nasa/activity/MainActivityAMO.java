package nasa.unam.mx.nasa.activity;

import android.util.Log;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nasa.unam.mx.nasa.BuildConfig;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.data.Data;
import nasa.unam.mx.nasa.model.Apod;
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
                    txt_date.setText(response.body().getDate());
                    txt_title.setText(response.body().getTitle());
                    txt_explanation.setText(response.body().getExplanation());

                    String url = response.body().getUrl();

                    Picasso.with(getApplicationContext()).load(url).into(image_view);
            }

            @Override
            public void onFailure(Call<Apod> call, Throwable t) {

            }
        });
    }
}
