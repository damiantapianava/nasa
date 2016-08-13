package nasa.unam.mx.nasa.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;

public class FBLoginActivity extends AppCompatActivity implements FacebookCallback<LoginResult>
{
    @BindView(R.id.fb_login_button)
    LoginButton btn_login;

    private CallbackManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        manager = CallbackManager.Factory.create();

        btn_login.registerCallback(manager, this);

        if(AccessToken.getCurrentAccessToken() != null)
        {
            //Snackbar.make(findViewById(android.R.id.content), "Login", Snackbar.LENGTH_SHORT).show();

            startActivity(new Intent(this, DrawerActivity.class));
        }

        //init_hash_key();
    }

    private void init_hash_key()
    {
        // Add code to print out the key hash
        try
        {
            PackageInfo info = getPackageManager().getPackageInfo("com.facebook.samples.hellofacebook", PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    @Override
    public void onSuccess(LoginResult loginResult)
    {
        //Snackbar.make(findViewById(android.R.id.content), "Success", Snackbar.LENGTH_SHORT).show();

        startActivity(new Intent(this, ListingActivity.class));
    }

    @Override
    public void onCancel()
    {
        Snackbar.make(findViewById(android.R.id.content), "Cancel", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onError(FacebookException error)
    {
        Snackbar.make(findViewById(android.R.id.content), "Error", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        manager.onActivityResult(requestCode, resultCode, data);
    }
}
