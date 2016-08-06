package nasa.unam.mx.nasa.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;

public class MainActivity extends MainActivityAMO
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init_flavor("MainActivity");
        init_today_apod();
        init_mars_rover_photos();
    }
}
