package nasa.unam.mx.nasa.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.data.Data;

public class ListingActivity extends ListingActivityAMO
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        ButterKnife.bind(this);

        service = Data.getInstance().create(ApodServiceIMO.class);

        init_adapter();
        init_mars_rover_photos();
    }
}
