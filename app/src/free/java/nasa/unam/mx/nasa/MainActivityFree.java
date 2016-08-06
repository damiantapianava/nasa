package nasa.unam.mx.nasa;

import android.os.Bundle;
import butterknife.ButterKnife;
import nasa.unam.mx.nasa.activity.MainActivityAMO;


public class MainActivityFree extends MainActivityAMO
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

        init_flavor("MainActivityFree");
        init_today_apod();
    }
}
