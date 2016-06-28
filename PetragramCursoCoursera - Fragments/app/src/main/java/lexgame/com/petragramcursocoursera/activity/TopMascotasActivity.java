package lexgame.com.petragramcursocoursera.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.adapter.MascotaAdaptador;
import lexgame.com.petragramcursocoursera.model.Mascota;

public class TopMascotasActivity extends AppCompatActivity {


    private ImageView imagenDerecha;
    private ArrayList<Mascota> mascotas2;
    private RecyclerView listaMascotas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_mascotas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imagenDerecha = (ImageView) findViewById(R.id.imgTopPet);
        imagenDerecha.setVisibility(View.INVISIBLE);

        listaMascotas2 = (RecyclerView) findViewById(R.id.rvTopMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas2.setLayoutManager(llm);

        inicializarListaMascota2();
        inicializarAdaptador2();
    }

    public void inicializarAdaptador2(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas2,this);
        listaMascotas2.setAdapter(adaptador);
    }

    public void inicializarListaMascota2(){
        mascotas2 = new ArrayList<Mascota>();

        mascotas2.add(new Mascota("Goliath",5,R.drawable.dog2));
        mascotas2.add(new Mascota("Mike",5,R.drawable.dog1));
        mascotas2.add(new Mascota("Zeus",5,R.drawable.dog4));
        mascotas2.add(new Mascota("Maris",5,R.drawable.dog5));
        mascotas2.add(new Mascota("Susy",5,R.drawable.dog3));


    }


}
