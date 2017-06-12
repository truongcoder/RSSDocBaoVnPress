package a200390.pctruong.com.docbaodantri.ControlAsyntask;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import a200390.pctruong.com.docbaodantri.ReadRSS.RSSItem;
import a200390.pctruong.com.docbaodantri.ReadRSS.RssParser;

/**
 * Created by PCTRUONG on 1/20/2017.
 */

public class ReadRSS extends AsyncTask<String,Void,ArrayList<RSSItem>> {
    Context context;
    RssParser rssParser;
    ArrayList<RSSItem> rssItems;
    public ReadRSS(Context context){
        this.context=context;
        rssParser=new RssParser();
    }
    @Override
    protected ArrayList<RSSItem> doInBackground(String... params) {
        rssItems= (ArrayList<RSSItem>) rssParser.getRSSFeedItems(params[0]);
        return rssItems;
    }
}
