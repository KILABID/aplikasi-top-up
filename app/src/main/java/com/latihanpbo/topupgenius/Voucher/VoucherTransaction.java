package com.latihanpbo.topupgenius.Voucher;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.latihanpbo.topupgenius.Home.MainActivity;
import com.latihanpbo.topupgenius.ListAdapter;
import com.latihanpbo.topupgenius.R;
import com.latihanpbo.topupgenius.produk;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VoucherTransaction#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VoucherTransaction extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VoucherTransaction() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VoucherTransaction.
     */
    // TODO: Rename and change types and number of parameters
    public static VoucherTransaction newInstance(String param1, String param2) {
        VoucherTransaction fragment = new VoucherTransaction();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voucher_transaction, container, false);
        // Inflate the layout for this fragment
        TextView selectedPriceTextView;
        TextView harga;
        selectedPriceTextView = view.findViewById(R.id.selectedPrice);
        ListView listView = view.findViewById(R.id.lvKomputer);
        harga = view.findViewById(R.id.tvHarga);

        List<produk> produkList = new ArrayList<>();
        produkList.add(new produk("125 Wallet", "15000"));
        produkList.add(new produk("420 Wallet", "50000"));
        produkList.add(new produk("700 Wallet", "80000"));
        produkList.add(new produk("1375 Wallet", "150000"));
        produkList.add(new produk("2400 Wallet", "250000"));
        produkList.add(new produk("4000 Wallet", "400000"));
        produkList.add(new produk("8150 Wallet", "800000"));

        ListAdapter adapter = new ListAdapter(requireContext(), produkList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                produk selectedProduk = produkList.get(position);
                harga.setText("Harga: Rp." + selectedProduk.getHarga());
                selectedPriceTextView.setText("Selected Product: " + selectedProduk.getNamaProduk());
            }
        });

        Button buy = view.findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Pembelian berhasil!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(requireContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}