package com.sahabul.dts2019ujian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.sahabul.dts2019ujian.adapter.MenuAdapter;
import com.sahabul.dts2019ujian.model.MenuMakanan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MenuAdapter.dataListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<MenuMakanan> listMenuMakanan;
    private MenuMakanan menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.dataMenuList);

        listMenuMakanan = new ArrayList<>();

        MyRecyclerView();



        GetData();
    }

    private void GetData() {
        menu = new MenuMakanan("B01", "Minuman", "Kopi Hitam", "Kopi Hitam dibuat dengan teknik espresso, dimana biji kopi yang digunakan yaitu berasal dari Aceh Gayo jenis Arabika, disajikan dengan gula terpisah", "10000");
        listMenuMakanan.add(menu);
        menu = new MenuMakanan("B02", "Minuman", "Cappuccino", "Paduan kopi dengan buih susu kental serta menggunakan sirup karamel, dimana biji kopi yang digunakan berasal dari Gunung Puntang, Jawa Barat jenis Robusta", "20000");
        listMenuMakanan.add(menu);
        menu = new MenuMakanan("M03", "Minuman", "Sparkling Tea", "Minuman Teh yang menggunakan daun teh dari pegunungan daerah Garut dengan tambahan sari melati asli dan gula merah alami", "15000");
        listMenuMakanan.add(menu);
        menu = new MenuMakanan("F01", "Makanan", "Batagor", "Baso dan Tahu Goreng dengan sajian bumbu kacang dan kecap khas Bandung", "25000");
        listMenuMakanan.add(menu);
        menu = new MenuMakanan("F02", "Makanan", "Cireng", "Makanan ringan berupa tepung kanji goreng isi bahan dasar tempe fermentasi yang disebut oncom, disajikan dengan bumbu kacang pedas", "10000");
        listMenuMakanan.add(menu);
        menu = new MenuMakanan("F03", "Makanan", "Nasi Goreng", "Nasi Goreng ayam yang disajikan dengan telur mata sapu disertai satai ayam", "50000");
        listMenuMakanan.add(menu);
        menu = new MenuMakanan("D01", "Dessert", "Cheese Cake", "Kue Tart 1 slice dengan bahan utama cream cheese dengan topping buah-buahan asli seperti anggur, jeruk, kiwi", "40000");
        listMenuMakanan.add(menu);
        menu = new MenuMakanan("D02", "Dessert", "Black Salad", "Potongan buah-buahan segar yang terdiri dari Pepaya, Jambu, Melon, dan Mangga disajikan dengan bumbu rujak kacang pedas dan gula merah", "30000");
        listMenuMakanan.add(menu);

        adapter = new MenuAdapter(listMenuMakanan, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private void MyRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.line));
        recyclerView.addItemDecoration(itemDecoration);
    }

    public void gotoPesan(View view) {
        Intent gotoPesan = new Intent(MainActivity.this, PesanActivity.class);
        startActivity(gotoPesan);
    }

    @Override
    public void onDeleteData(Menu data, int position) {

    }
}
