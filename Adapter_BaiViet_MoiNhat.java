package a200390.pctruong.com.docbaodantri.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import a200390.pctruong.com.docbaodantri.Activity.Activity_Content;
import a200390.pctruong.com.docbaodantri.Activity.Activity_Share;
import a200390.pctruong.com.docbaodantri.Activity.Activity_Splash;
import a200390.pctruong.com.docbaodantri.CheckConnectInternet.ConnectInternet;
import a200390.pctruong.com.docbaodantri.Create_DatabaseSQLite.XuLyDataBase;
import a200390.pctruong.com.docbaodantri.R;
import a200390.pctruong.com.docbaodantri.ReadRSS.RSSItem;

/**
 * Created by PCTRUONG on 1/20/2017.
 */

public class Adapter_BaiViet_MoiNhat extends RecyclerView.Adapter<Adapter_BaiViet_MoiNhat.Viewholder_BV_MoiNhat> {
    Context context;
    int layout;
    ArrayList<RSSItem> rssItemArrayList;
    boolean kiemtra = false;

    public Adapter_BaiViet_MoiNhat(Context context, int layout, ArrayList<RSSItem> rssItemArrayList, boolean kiemtra) {
        this.context = context;
        this.layout = layout;
        this.rssItemArrayList = rssItemArrayList;
        this.kiemtra = kiemtra;
    }

    @Override
    public Viewholder_BV_MoiNhat onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_baiviet, parent, false);
        return new Viewholder_BV_MoiNhat(view);
    }

    @Override
    public void onBindViewHolder(final Viewholder_BV_MoiNhat holder, final int position) {
        holder.txt_title.setText(rssItemArrayList.get(position).getTitle());
        holder.txt_pubdate.setText(rssItemArrayList.get(position).getPubdate());
        if (kiemtra == true) {
            holder.img_delete.setVisibility(View.GONE);
            holder.img_love.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XuLyDataBase xuLyDataBase = new XuLyDataBase(context);
                    RSSItem rssItem = new RSSItem();
                    rssItem.setTitle(rssItemArrayList.get(position).getTitle());
                    rssItem.setImg(rssItemArrayList.get(position).getImg());
                    rssItem.setPubdate(rssItemArrayList.get(position).getPubdate());
                    rssItem.setLink(rssItemArrayList.get(position).getLink());
                    boolean kt = xuLyDataBase.them_BaiViet(rssItem);
                    if (kt) {
                        Toast.makeText(context, "Lưu bài viết thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Lưu bài viết không thành công", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        } else {
            holder.img_delete.setVisibility(View.VISIBLE);
            holder.img_love.setVisibility(View.GONE);
            holder.img_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final XuLyDataBase xuLyDataBase = new XuLyDataBase(context);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Bạn có thực sự muốn xóa ?");
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            boolean kt = xuLyDataBase.Xoa_BaiViet(rssItemArrayList.get(position).getId());
                            if (kt) {
                                Toast.makeText(context, " Xóa thành công", Toast.LENGTH_SHORT).show();
                                rssItemArrayList.remove(position);
                                notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }
            });
        }
        dowloadImage dowloadImage = new dowloadImage();
        dowloadImage.execute(rssItemArrayList.get(position).getImg());
        try {
            holder.imageView.setImageBitmap(dowloadImage.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Activity_Content.class);
                intent.putExtra("link", rssItemArrayList.get(position).getLink());
                context.startActivity(intent);
            }
        });
        holder.img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Activity_Share.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", rssItemArrayList.get(position));
                intent.putExtra("data", bundle);
                context.startActivity(intent);
            }
        });

    }

    class dowloadImage extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmap;

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }

    @Override
    public int getItemCount() {
        return rssItemArrayList.size();
    }

    public class Viewholder_BV_MoiNhat extends RecyclerView.ViewHolder {
        TextView txt_title, txt_pubdate;
        ImageView imageView;
        ImageButton img_love, img_share, img_delete;
        ProgressBar progressBar;

        public Viewholder_BV_MoiNhat(View itemView) {
            super(itemView);
            txt_pubdate = (TextView) itemView.findViewById(R.id.txt_pubdate);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            imageView = (ImageView) itemView.findViewById(R.id.img_baiviet);
            img_love = (ImageButton) itemView.findViewById(R.id.img_love);
            img_share = (ImageButton) itemView.findViewById(R.id.img_share);
            img_delete = (ImageButton) itemView.findViewById(R.id.img_delete);
            progressBar = (ProgressBar) itemView.findViewById(R.id.pro_barItem);
        }
    }
}
