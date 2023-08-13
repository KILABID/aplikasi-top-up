package com.latihanpbo.topupgenius.Mobile;

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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MobileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MobileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MobileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MobileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MobileFragment newInstance(String param1, String param2) {
        MobileFragment fragment = new MobileFragment();
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
        View view = inflater.inflate(R.layout.fragment_mobile, container, false);
        RecyclerView rvGame = view.findViewById(R.id.rvMobile);
        rvGame.setLayoutManager(new LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false));

        List<ModelMobile> modelMobileList = new ArrayList<>();
        modelMobileList.add(new ModelMobile("Mobile Legend", R.drawable.mobile_legend));
        modelMobileList.add(new ModelMobile("Free Fire", R.drawable.free_fire));
        modelMobileList.add(new ModelMobile("PUBG Mobile", R.drawable.pubgm));
        modelMobileList.add(new ModelMobile("Call Of Duty Mobile", R.drawable.codm));
        modelMobileList.add(new ModelMobile("Wild Rift", R.drawable.wildrift));

        MobileAdapter mobileAdapter = new MobileAdapter(modelMobileList);
        rvGame.setAdapter(mobileAdapter);

        mobileAdapter.setOnItemClickListener(modelMobile -> {
            String title = modelMobile.getTvGame();
            Intent intent = new Intent(requireContext(), TransactionActivity.class);
            intent.putExtra("transaction", title);

            switch (title){
                case "Mobile Legend" :
                    startActivity(intent);
                    break;
                case "Free Fire" :
                    startActivity(intent);
                    break;
                case "PUBG Mobile" :
                    startActivity(intent);
                    break;
                case "Call Of Duty Mobile" :
                    startActivity(intent);
                case "Wild Rift" :
                    startActivity(intent);
                default:
                    break;
            }
        });

        return view;
    }
}