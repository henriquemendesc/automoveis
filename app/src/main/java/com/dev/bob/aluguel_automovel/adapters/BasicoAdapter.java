package com.dev.bob.aluguel_automovel.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dev.bob.aluguel_automovel.Model.Automoveis;
import com.dev.bob.aluguel_automovel.R;

import java.util.ArrayList;

/**
 * Created by Bob on 07/11/2017.
 */

public class BasicoAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private View view;
    private Holder holder;
    private ArrayList<Automoveis> automoveis;

    public BasicoAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Automoveis> objects) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.automoveis = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(resource, parent,false);

        holder=new Holder();
        holder.txtNomeBasico=(TextView)view.findViewById(R.id.txtNome);
        holder.txtDisponivelBasico=(TextView)view.findViewById(R.id.txtDisponivel);
        holder.txtNomeBasico.setText(automoveis.get(position).name);
        holder.txtNomeBasico.setText(automoveis.get(position).disponivel);

        return view;
    }

    @Override
    public int getCount() {
        return automoveis.size();
    }

    @Override
    public Object getItem(int position) {
        return automoveis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView txtNomeBasico;
        TextView txtDisponivelBasico;
    }
}
