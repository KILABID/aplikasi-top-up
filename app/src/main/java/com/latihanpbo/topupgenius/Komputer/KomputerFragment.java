package com.latihanpbo.topupgenius.Komputer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.latihanpbo.topupgenius.R;
import com.latihanpbo.topupgenius.TransactionActivity;
import com.latihanpbo.topupgenius.Mobile.MobileAdapter;
import com.latihanpbo.topupgenius.Mobile.ModelMobile;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KomputerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KomputerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KomputerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KomputerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KomputerFragment newInstance(String param1, String param2) {
        KomputerFragment fragment = new KomputerFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_komputer, container, false);
        RecyclerView rvGameKomp = view.findViewById(R.id.rvKomputer);
        rvGameKomp.setLayoutManager(new LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false));

        List<ModelMobile> modelMobileList = new ArrayList<>();
        modelMobileList.add(new ModelMobile("Valorant", R.drawable.valorant));
        modelMobileList.add(new ModelMobile("Roblox", R.drawable.robux));
        modelMobileList.add(new ModelMobile("Garena Shell", R.drawable.garena));

        MobileAdapter mobileAdapter = new MobileAdapter(modelMobileList);
        rvGameKomp.setAdapter(mobileAdapter);

        mobileAdapter.setOnItemClickListener(modelMobile -> {
            String title = modelMobile.getTvGame();
            Intent intent = new Intent(requireContext(), TransactionActivity.class);
            intent.putExtra("transaction", title);

            switch (title){
                case "Valorant" :
                    startActivity(intent);
                    break;
                case "Roblox" :
                    startActivity(intent);
                    break;
                case "Garena Shell" :
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        });
        return view;
    }
}