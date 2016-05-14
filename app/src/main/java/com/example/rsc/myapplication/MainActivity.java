package com.example.rsc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    ArrayList <Mascota> mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Proximamente fotos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Rocky",R.drawable.perro_02,0));
        mascotas.add(new Mascota("Aquiles",R.drawable.perro_01,0));
        mascotas.add(new Mascota("Mike",R.drawable.perro_03,0));
        mascotas.add(new Mascota("Mateo",R.drawable.perro_04,0));
        mascotas.add(new Mascota("Bolillo",R.drawable.perro_05,0));



        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new MascotaAdapter(mascotas);
        recycler.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.favoritos) {
            Intent intent=new Intent(MainActivity.this,FavoritosActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("mascotas",mascotas);
            intent.putExtras(bundle);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
