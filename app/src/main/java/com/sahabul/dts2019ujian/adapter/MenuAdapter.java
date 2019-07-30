package com.sahabul.dts2019ujian.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sahabul.dts2019ujian.MainActivity;
import com.sahabul.dts2019ujian.R;
import com.sahabul.dts2019ujian.model.MenuMakanan;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<MenuMakanan> listMenuMakanans;
    private Context context;

    public interface dataListener{
        void onDeleteData(android.view.Menu data, int position);
    }

    dataListener listener;

    public MenuAdapter(ArrayList<MenuMakanan> listMenuMakanans, Context context) {
        this.listMenuMakanans = listMenuMakanans;
        this.context = context;
        listener = (MainActivity)context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView kode, jenis, nama, penjelasan, harga;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            kode = itemView.findViewById(R.id.textKodeMenu);
            jenis = itemView.findViewById(R.id.textJenisMenu);
            nama = itemView.findViewById(R.id.textNamaMenu);
            penjelasan = itemView.findViewById(R.id.textPenjelasanMenu);
            harga = itemView.findViewById(R.id.textHargaMenu);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_view_design, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String kode = listMenuMakanans.get(position).getKode();
        final String jenis = listMenuMakanans.get(position).getJenis();
        final String nama = listMenuMakanans.get(position).getNama();
        final String penjelasan = listMenuMakanans.get(position).getPenjelasan();
        final String harga = listMenuMakanans.get(position).getHarga();

        holder.kode.setText("Kode : " + kode);
        holder.jenis.setText("Jenis : " + jenis);
        holder.nama.setText("Nama : " + nama);
        holder.harga.setText("Harga : " + harga);

        holder.ListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String[] action = {"\n" + nama + " :" + "\n" + penjelasan + "\n"};
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setItems(action,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){
                            case 0:
//                                Bundle bundle = new Bundle();
//                                Intent gotoUpdatePenduduk = new Intent(view.getContext(), UpdatePendudukActivity.class);
//                                gotoUpdatePenduduk.putExtras(bundle);
//                                context.startActivity(gotoUpdatePenduduk);
                                break;
                            case 1:
//                                listener.onDeleteData(listMenuMakanans.get(position), position);
                                break;
                        }
                    }
                });
                alert.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMenuMakanans.size();
    }
}
