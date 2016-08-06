package nasa.unam.mx.nasa;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nasa.unam.mx.nasa.model.Apod;
import nasa.unam.mx.nasa.model.MarsRoverResponse;
import nasa.unam.mx.nasa.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityFree extends MainActivityDMO
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

/*
        image_view = (ImageView) findViewById();
        txt_date = (TextView) findViewById();
        txt_title = (TextView) findViewById();
        txt_explanation = (TextView) findViewById();
*/

        sb = new StringBuilder();
        sb.append("FLAVOR: ").append(BuildConfig.FLAVOR).append(" ");
        sb.append("URL: ").append(BuildConfig.URL);

        Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
        Log.d("MainActivityFree: ", sb.toString());

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

        manager = new LinearLayoutManager(this);
        //manager = new GridLayoutManager(this, 2);
        recycler_view.setLayoutManager(manager);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
