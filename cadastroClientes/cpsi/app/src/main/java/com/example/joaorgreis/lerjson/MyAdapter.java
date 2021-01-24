package com.example.joaorgreis.lerjson;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends SimpleAdapter {

    private static final String KEY_IMGURL = "imgUrl";

    public MyAdapter(Context context, List<? extends Map<String, ?>> data, int  resource,String[] from,int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView,parent);
        CircleImageView img = (CircleImageView) v.getTag();
        if (img==null){
            img = (CircleImageView) v.findViewById(R.id.itemImagem);
            v.setTag(img);
        }
        String url = ((Map)getItem(position)).get(KEY_IMGURL).toString();

        Picasso
                .get()
                .load(url)
                .into(img);

        return v;
    }
}
