package nasa.unam.mx.nasa.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONObject;

import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;

public class DrawerActivity extends DrawerActivityAMO
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        init_navigation_view();

        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback()
        {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response)
            {
                try
                {
                    SimpleDraweeView userImage = (SimpleDraweeView) findViewById(R.id.img_user_fb);
                    TextView user_name = (TextView) findViewById(R.id.txt_user_name);

                    userImage.setImageURI("http://graph.facebook.com/" + object.getString("id") + "/picture?type=large");

                    user_name.setText(object.getString("name"));

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        request.executeAsync();
    }
}
