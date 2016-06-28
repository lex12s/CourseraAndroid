package lexgame.com.petragramcursocoursera.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.adapter.MascotaAdaptador;
import lexgame.com.petragramcursocoursera.adapter.MascotaPerfilAdaptador;
import lexgame.com.petragramcursocoursera.model.ConstructorMascota;
import lexgame.com.petragramcursocoursera.model.Mascota;
import lexgame.com.petragramcursocoursera.presentador.PerfilFragmentPresenter;
import lexgame.com.petragramcursocoursera.presentador.PerfilFragmentPresenterI;
import lexgame.com.petragramcursocoursera.presentador.RecyclerFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements PerfilFragmentI{


    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas2;
    private ConstructorMascota constructorMascota;
    private Context context;
    private PerfilFragmentPresenterI presenter;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas2 = (RecyclerView) v.findViewById(R.id.rv_perfil);
        presenter = new PerfilFragmentPresenter(this,getContext());

        /*
        final GridLayoutManager glm= new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);
        listaMascotas.setHasFixedSize(true);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascota();
        inicializarAdaptador();
        */

        return v;
    }

    @Override
    public void generarGridLayout() {
        final GridLayoutManager glm= new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);
        listaMascotas2.setHasFixedSize(true);
        listaMascotas2.setLayoutManager(glm);
    }

    @Override
    public MascotaPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascota) {
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascota, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaPerfilAdaptador adaptador) {
        listaMascotas2.setAdapter(adaptador);
    }
    /*

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascota(){

        constructorMascota = new ConstructorMascota(getContext());

        mascotas = constructorMascota.obtenerMascota();

        mascotas.add(new Mascota("Mike",5,R.drawable.dog1));
        mascotas.add(new Mascota("Goliath",5,R.drawable.dog2));
        mascotas.add(new Mascota("Susy",5,R.drawable.dog3));
        mascotas.add(new Mascota("Zeus",5,R.drawable.dog4));
        mascotas.add(new Mascota("Maris",5,R.drawable.dog5));

    }

    */
}
