package com.dev.bob.aluguel_automovel.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.bob.aluguel_automovel.R;

public class BasicoTabFragment extends Fragment {


    public BasicoTabFragment() {
        // Required empty public constructor
    }

    public static BasicoTabFragment newInstance(String param1, String param2) {
        BasicoTabFragment fragment = new BasicoTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basico_tab, container, false);
        return view;
    }


}
