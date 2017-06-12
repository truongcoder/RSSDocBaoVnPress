package a200390.pctruong.com.docbaodantri.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import a200390.pctruong.com.docbaodantri.Adapter.Adapter_BaiViet_MoiNhat;
import a200390.pctruong.com.docbaodantri.Create_DatabaseSQLite.XuLyDataBase;
import a200390.pctruong.com.docbaodantri.R;
import a200390.pctruong.com.docbaodantri.ReadRSS.RSSItem;

public class MainActivity_Display_Info extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<RSSItem> arrayList;
    Adapter_BaiViet_MoiNhat adapter_display_info;
    XuLyDataBase xuLyDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_baiviet);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        arrayList = new ArrayList<>();
        xuLyDataBase = new XuLyDataBase(this);
        arrayList = xuLyDataBase.LayDanhSachBaiViet();
        adapter_display_info = new Adapter_BaiViet_MoiNhat(this, R.layout.item_baiviet, arrayList,false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter_display_info);
        adapter_display_info.notifyDataSetChanged();



    }
}
