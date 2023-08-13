package com.latihanpbo.topupgenius.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.latihanpbo.topupgenius.LoginRegister.Login;
import com.latihanpbo.topupgenius.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AkunFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AkunFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AkunFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AkunFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AkunFragment newInstance(String param1, String param2) {
        AkunFragment fragment = new AkunFragment();
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
        View view = inflater.inflate(R.layout.fragment_akun, container, false);
        // Inflate the layout for this fragment
        Button logoutbtn = view.findViewById(R.id.logout);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(requireContext(), Login.class);
                startActivity(logout);
            }
        });

        Button caraPembelian = view.findViewById(R.id.cara_pembelian);
        caraPembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), CaraPembelian.class);
                startActivity(intent);
            }
        });
        String value = null;
        
        Bundle bundle = getArguments();
        if (bundle != null) {
            value = bundle.getString("username");
            TextView username = view.findViewById(R.id.tv_username);
            username.setText(value);
        }



        return view;
    }
}