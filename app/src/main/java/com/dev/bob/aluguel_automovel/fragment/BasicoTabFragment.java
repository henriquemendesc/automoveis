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
import com.dev.bob.aluguel_automovel.adapters.ExecutivoAdapter;

import java.util.ArrayList;

public class BasicoTabFragment extends Fragment {
    private ArrayList<Automoveis> automoveis = new ArrayList<>();
    private DBAutomoveis dbAutomoveis;

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
        dbAutomoveis = new DBAutomoveis(getContext());
        automoveis = dbAutomoveis.getAutoByType("Executivo");
        BasicoAdapter basicoAdapter = new BasicoAdapter(getActivity(),R.layout.list_basico,automoveis);
        ListView listView = (ListView)view.findViewById(R.id.listview_basico);
        listView.setAdapter(basicoAdapter);
        return view;

    }
}
