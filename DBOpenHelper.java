package library.carpool.util;

/**
 * Created by gautami on 3/19/2016.
 */
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class used to open database file
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    public DBOpenHelper(Context context, String path, int version){
        super(context, path, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
