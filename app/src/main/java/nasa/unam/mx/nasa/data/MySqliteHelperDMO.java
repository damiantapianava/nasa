package nasa.unam.mx.nasa.data;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public abstract class MySqliteHelperDMO extends SQLiteOpenHelper
{
    public static final String TAG = "nasa_apod_tag";

    public static final String COLUMN_ID = BaseColumns._ID;

    public static final String   DATABASE_NAME   = "nasa_apod";
    public static final String      TABLE_NAME   = "gn_apod_favorites";
    public static final String COLUMN_ROVER_NAME = "rover_name";
    public static final String COLUMN_EARTH_DATE = "earth_date";
    public static final String COLUMN_IMG_SRC    = "img_src";
    public static final String COLUMN_CAMERA_FULL_NAME = "camera_full_name";

    public final static int DATABASE_VERSION = 1;

    protected static final String CREATE_TABLE  = "create table IF NOT EXISTS " +
            TABLE_NAME      + " ( " +
            COLUMN_ID       + " integer primary key autoincrement,"+
            COLUMN_ROVER_NAME + " text not null,"+
            COLUMN_EARTH_DATE + " text not null,"+
            COLUMN_IMG_SRC    + " text not null,"+
            COLUMN_CAMERA_FULL_NAME + " text not null)";

    public MySqliteHelperDMO(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
