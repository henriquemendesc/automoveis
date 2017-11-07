package com.dev.bob.aluguel_automovel.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.bob.aluguel_automovel.Model.Automoveis;
import com.dev.bob.aluguel_automovel.Model.DBAutomoveis;
import com.dev.bob.aluguel_automovel.R;
import com.dev.bob.aluguel_automovel.adapters.BasicoAdapter;
import com.dev.bob.aluguel_automovel.adapters.IntermediarioAdapter;

import java.util.ArrayList;

public class IntermediarioTabFragment extends Fragment {
    private ArrayList<Automoveis> automoveis = new ArrayList<>();
    private DBAutomoveis dbAutomoveis;

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
        /*dbAutomoveis = new DBAutomoveis(getContext());
        automoveis = dbAutomoveis.getAutoByType("Executivo");*/
        IntermediarioAdapter intAdapter = new IntermediarioAdapter(getActivity(),R.layout.list_intermediario,automoveis);
        ListView listView = (ListView)view.findViewById(R.id.listview_inter);
        listView.setAdapter(intAdapter);
        return view;

    }
}
