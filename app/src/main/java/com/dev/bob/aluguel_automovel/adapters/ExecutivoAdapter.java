package com.dev.bob.aluguel_automovel.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dev.bob.aluguel_automovel.Model.Automoveis;
import com.dev.bob.aluguel_automovel.R;

import java.util.ArrayList;

/**
 * Created by Bob on 07/11/2017.
 */

public class ExecutivoAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    private View view;
    private Holder holder;
    private ArrayList<Automoveis> automoveis;

    public ExecutivoAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Automoveis> objects) {
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
        holder.txtNomeExec=(TextView)view.findViewById(R.id.txtNomeExec);
        holder.txtDisponivelExec=(TextView)view.findViewById(R.id.txtDisponivelExec);
        holder.txtNomeExec.setText(automoveis.get(0).name);
        holder.txtNomeExec.setText(automoveis.get(0).disponivel);

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
        TextView txtNomeExec;
        TextView txtDisponivelExec;
    }
}
