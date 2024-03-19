package com.example.assign04_6406021622095;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StackViewAdapter extends ArrayAdapter {
    Context context;
    private List<String> storeList;
    private int itemLayout;

    public StackViewAdapter(StackViews ctx, int item, List<String> stores) {
        super(ctx, item, stores);
        storeList = stores;
        itemLayout = item;
        context = ctx;
    }

    @Override
    public int getCount() {
        return storeList.size();
    }

    @Override
    public Object getItem(int position) {
        return storeList.get(position);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        }

        String store = storeList.get(position);
        TextView storeName = (TextView) convertView.findViewById(R.id.name);
        ImageView storeImage = (ImageView) convertView.findViewById(R.id.image);
        storeName.setText(store);
        int resId = context.getResources().getIdentifier(store, "drawable",

                context.getPackageName());
        storeImage.setImageResource(resId);
        return convertView;

    }
}
