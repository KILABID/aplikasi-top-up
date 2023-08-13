package com.latihanpbo.topupgenius;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class ListAdapter extends ArrayAdapter<produk> {
    private Context context;
    private List<produk> produkList;

    public ListAdapter(Context context, List<produk> produkList) {
        super(context, 0, produkList);
        this.context = context;
        this.produkList = produkList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_produk, parent, false);
        }

        TextView produkTextView = convertView.findViewById(R.id.produk);
        TextView hargaTextView = convertView.findViewById(R.id.harga);

        produk produk = produkList.get(position);
        produkTextView.setText(produk.getNamaProduk());
        hargaTextView.setText(produk.getHarga());

        return convertView;
    }
}
