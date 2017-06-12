package a200390.pctruong.com.docbaodantri.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import a200390.pctruong.com.docbaodantri.Adapter.Adapter_BaiViet_MoiNhat;
import a200390.pctruong.com.docbaodantri.R;
import a200390.pctruong.com.docbaodantri.ControlAsyntask.ReadRSS;
import a200390.pctruong.com.docbaodantri.ReadRSS.RSSItem;

/**
 * Created by PVTruong on 03/03/2017.
 */

public class Fragment_TinhYeu extends Fragment {
    View view;
    RecyclerView recyclerView;
    Adapter_BaiViet_MoiNhat adapter;
    ArrayList<RSSItem> arrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_baiviet, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recycle_view);
        arrayList=new ArrayList<>();
        ReadRSS readRSS =new ReadRSS(getActivity());
        readRSS.execute("http://dantri.com.vn/tinh-yeu-gioi-tinh.rss");
        try {
            arrayList= readRSS.get();
            adapter=new Adapter_BaiViet_MoiNhat(getActivity(),R.layout.item_baiviet,arrayList,true);
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return  view;
    }
}
