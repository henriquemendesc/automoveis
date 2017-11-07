package com.dev.bob.aluguel_automovel.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.bob.aluguel_automovel.R;

public class IntermediarioTabFragment extends Fragment {

    public IntermediarioTabFragment() {
        // Required empty public constructor
    }
    public static IntermediarioTabFragment newInstance(String param1, String param2) {
        IntermediarioTabFragment fragment = new IntermediarioTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intermediario_tab, container, false);
        return view;
    }
}
