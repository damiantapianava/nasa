package nasa.unam.mx.nasa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityFree extends AppCompatActivity
{
    private ImageView image_view;
    private TextView txt_title;
    private TextView txt_date;
    private TextView txt_explanation;

    private ApodServiceIMO service;
    private Call<Apod> request;

    private StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_view = (ImageView) findViewById(R.id.iv_app_ic);
        txt_date = (TextView) findViewById(R.id.txt_date);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_explanation = (TextView) findViewById(R.id.txt_explanation);

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
