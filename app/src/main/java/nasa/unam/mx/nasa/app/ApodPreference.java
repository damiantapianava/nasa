package nasa.unam.mx.nasa.app;

import android.content.SharedPreferences;
import android.content.Context;
import android.text.TextUtils;

import nasa.unam.mx.nasa.model.ApodFavorite;


public class ApodPreference
{
    private static final String FILE_NAME = "apod_favorite";

    private final SharedPreferences sp;

    public ApodPreference(Context context)
    {
        sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public void setApodFavorite(ApodFavorite favorite)
    {
        sp.edit().putString("apod_imgSrc",  favorite.getImgSrc()).apply();
        sp.edit().putString("apod_cameraFullName", favorite.getCameraFullName()).apply();
        sp.edit().putString("apod_earthDate", favorite.getEarthDate()).apply();
        sp.edit().putString("apod_roverNAme", favorite.getRoverName()).apply();
    }

    public ApodFavorite getApodFavorite()
    {
        String imgSrc         = sp.getString("apod_imgSrc",null);
        String cameraFullName = sp.getString("apod_cameraFullName",null);
        String earthDate      = sp.getString("apod_earthDate",null);
        String roverNAme      = sp.getString("apod_roverNAme",null);

        if(TextUtils.isEmpty(imgSrc))
        {
            return null;
        }

        ApodFavorite favorite = new ApodFavorite();
        favorite.setImgSrc(imgSrc);
        favorite.setCameraFullName(cameraFullName);
        favorite.setEarthDate(earthDate);
        favorite.setRoverName(roverNAme);

        return favorite;
    }

    /*
    public void saveElapsedTime(int seconds)
    {
        sp.edit().putInt("elapsed_time", seconds);
    }

    public int getElapsedTime()
    {
        return sp.getInt("elapsed_time", 0);
    }


    public void saveUserId(ModelUser modelUser)
    {
        sp.edit().putInt("user_id",  modelUser.getId()).apply();
        sp.edit().putString("user_name",     modelUser.getUserName()).apply();
        sp.edit().putString("user_password", modelUser.getPassword()).apply();
    }

    public Integer getUserId()
    {
        Integer user_id = sp.getInt("user_id", -1);

        return user_id;
    }

    public void remove(String key)
    {
        sp.edit().remove(key).apply();
    }

        public void setRemember_login_ENABLED(boolean remember_login_ENABLED)
    {
        sp.edit().putBoolean("key_remember_login", remember_login_ENABLED).apply();
    }

    public boolean isRemember_login_ENABLED()
    {
        remember_login_ENABLED = sp.getBoolean("key_remember_login", false);

        return remember_login_ENABLED;
    }
*/
}
