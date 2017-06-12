package a200390.pctruong.com.docbaodantri.Create_DatabaseSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import a200390.pctruong.com.docbaodantri.ReadRSS.RSSItem;

/**
 * Created by PCTRUONG on 2/7/2017.
 */

public class XuLyDataBase {
    Context context;
    SQLiteDatabase db;
    Data_base dataBase;
    public XuLyDataBase(Context context) {
        this.context = context;
        dataBase=new Data_base(context);
    }
    public boolean them_BaiViet(RSSItem rssItem){
        db=dataBase.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(Data_base.TB_Title,rssItem.getTitle());
        content.put(Data_base.TB_Img,rssItem.getImg());
        content.put(Data_base.TB_Pubdate,rssItem.getPubdate());
        content.put(Data_base.TB_Link,rssItem.getLink());
        long kt=db.insert(Data_base.table_name,null,content);
        if(kt!=0){
            return true;
        }
        return false;
    }
    public ArrayList<RSSItem> LayDanhSachBaiViet(){
        ArrayList<RSSItem> arrayList=new ArrayList<>();
        db=dataBase.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from " +Data_base.table_name,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            RSSItem rssItem=new RSSItem();
            rssItem.setId(cursor.getInt(0));
            rssItem.setTitle(cursor.getString(1));
            rssItem.setImg(cursor.getString(2));
            rssItem.setPubdate(cursor.getString(3));
            rssItem.setLink(cursor.getString(4));
            arrayList.add(rssItem);
            cursor.moveToNext();

        }
        return arrayList;
    }
    public boolean Xoa_BaiViet(int id){
        db = dataBase.getWritableDatabase();
        long kt=  db.delete(Data_base.table_name,Data_base.TB_Id + "=?" ,new String[]{String.valueOf(id)});
        if(kt!=0){
          return true;
        }
        return false;
    }
}
