package nasa.unam.mx.nasa.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import nasa.unam.mx.nasa.model.ApodFavorite;

public class ApodFavoriteDAO
{
    private MySqliteHelper helper;

    private SQLiteDatabase db;

    private ContentValues contentValues;

    private String selection;

    private String[] selectionArgs;

    public ApodFavoriteDAO(Context context)
    {
        helper = new MySqliteHelper(context);

        db = helper.getWritableDatabase();
    }

    public boolean persist(ApodFavorite favorite)
    {
        contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.COLUMN_CAMERA_FULL_NAME, favorite.getCameraFullName());
        contentValues.put(MySqliteHelper.COLUMN_ROVER_NAME,   favorite.getRoverName());
        contentValues.put(MySqliteHelper.COLUMN_EARTH_DATE,   favorite.getEarthDate());
        contentValues.put(MySqliteHelper.COLUMN_IMG_SRC,      favorite.getImgSrc());

        long row_id = db.insert(MySqliteHelper.TABLE_NAME, null, contentValues);

        if(row_id > 0)
        {
            return true;

        }  else {

            return false;
        }
    }

    public List<ApodFavorite> getLista_ApodFavorite()
    {
        List<ApodFavorite> modelItemList = new ArrayList<>();

        Cursor cursor = db.query(MySqliteHelper.TABLE_NAME,null,null,null,null,null,null);

        while (cursor.moveToNext())
        {
            int id = cursor.getInt   (cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ID));
            String cameraFullName = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_CAMERA_FULL_NAME));
            String roverName  = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ROVER_NAME));
            String earthDate  = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_EARTH_DATE));
            String imgSrc     = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_IMG_SRC));

            ApodFavorite favorite = new ApodFavorite();
            favorite.setId(id);
            favorite.setCameraFullName(cameraFullName);
            favorite.setRoverName(roverName);
            favorite.setEarthDate(earthDate);
            favorite.setImgSrc(imgSrc);

            modelItemList.add(favorite);
        }

        return modelItemList;
    }

/*
    public boolean update(ApodFavorite favorite)
    {
        selection = MySqliteHelper.COLUMN_ID + " = ?";

        selectionArgs = new String[]{favorite.getApp_info_id() + ""};

        contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.COLUMN_CAMERA_FULL_NAME, favorite.getCameraFullName());
        contentValues.put(MySqliteHelper.COLUMN_ROVER_NAME, favorite.getRoverName());
        contentValues.put(MySqliteHelper.COLUMN_EARTH_DATE, favorite.getEarthDate());
        contentValues.put(MySqliteHelper.COLUMN_IMG_SRC,    favorite.getImgSrc());

        long row_id = db.update(MySqliteHelper.TABLE_NAME, contentValues, selection, selectionArgs);

        if(row_id > 0)
        {
            return true;

        }  else {

            return false;
        }
    }

    public boolean delete(ApodFavorite info)
    {
        selection = MySqliteHelper.COLUMN_ID + " = ?";

        selectionArgs = new String[]{info.getApp_info_id() + ""};

        long row_id = db.delete(MySqliteHelper.TABLE_NAME, selection, selectionArgs);

        if(row_id > 0)
        {
            return true;

        }  else {

            return false;
        }
    }
*/
}
