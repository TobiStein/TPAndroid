package com.khalissa.bontest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Contact> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Contact> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.flagView = (ImageView) convertView.findViewById(R.id.imageView_profile);
            holder.contactnomNameView = (TextView) convertView.findViewById(R.id.textView_contactNom);
            holder.contactNumeroView = (TextView) convertView.findViewById(R.id.textView_contactNumero);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contact cont = this.listData.get(position);
        holder.contactnomNameView.setText(cont.getPrenom() + " " + cont.getNom());
        holder.contactNumeroView.setText("Population: " + cont.getNumeroTel());
        int imageId = context.getResources().getIdentifier("profil", "mipmap", context.getPackageName());

        holder.flagView.setImageResource(imageId);

        return convertView;
    }

    static class ViewHolder {
        ImageView flagView;
        TextView contactnomNameView;
        TextView contactNumeroView;
    }

}
