package lexgame.com.petragramcursocoursera.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.adapter.PageAdapter;
import lexgame.com.petragramcursocoursera.fragments.PerfilFragment;
import lexgame.com.petragramcursocoursera.fragments.RecyclerFragment;
import lexgame.com.petragramcursocoursera.model.Mascota;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("");

        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();


        /*
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        inicializarAdaptador();
        */
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icon_1);
        tabLayout.getTabAt(1).setIcon(R.drawable.icon_2);
    }
    /*
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascota(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Mike",5,R.drawable.dog1));
        mascotas.add(new Mascota("Goliath",5,R.drawable.dog2));
        mascotas.add(new Mascota("Susy",5,R.drawable.dog3));
        mascotas.add(new Mascota("Zeus",5,R.drawable.dog4));
        mascotas.add(new Mascota("Maris",5,R.drawable.dog5));
    }*/

    public void Detalle(View v){
        Intent intent = new Intent(MainActivity.this,TopMascotasActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.aboutOption:      Intent intent = new Intent(this,AboutActivity.class);
                                        startActivity(intent);
                                        break;
            case R.id.contactoOption:   Intent intent1 = new Intent(this,ContactoActivity.class);
                                        startActivity(intent1);
                                        break;
        }

        return super.onOptionsItemSelected(item);
    }
}
