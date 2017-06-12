package a200390.pctruong.com.docbaodantri.Create_DatabaseSQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PCTRUONG on 1/19/2017.
 */

public class Data_base extends SQLiteOpenHelper {
    private static String data_nanme = "dbBaiViet";
    public static String table_name = "BaiViet";
    public static String TB_Id = "Id";
    public static String TB_Title = "Title";
    public static String TB_Img = "Img";
    public static String TB_Link="Link";
    public static String TB_Pubdate = "Pubdate";

    public Data_base(Context context) {
        super(context, data_nanme, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + table_name + "(" + TB_Id + " Integer primary key autoincrement, " + TB_Title + " text,"
                + TB_Img + " text," + TB_Pubdate + " text ," +TB_Link+ " text "+
                " )";
        db.execSQL(sql);
       
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("crop table if exists " + table_name);
        onCreate(db);

    }
}
