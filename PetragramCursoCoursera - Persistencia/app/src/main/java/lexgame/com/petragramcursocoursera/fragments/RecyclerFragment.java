package lexgame.com.petragramcursocoursera.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.adapter.MascotaAdaptador;
import lexgame.com.petragramcursocoursera.model.Mascota;
import lexgame.com.petragramcursocoursera.presentador.RecyclerFragmentPresenter;
import lexgame.com.petragramcursocoursera.presentador.RecyclerFragmentPresenterI;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment implements RecyclerFragmentI{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerFragmentPresenterI presenter;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerFragmentPresenter(this,getContext());

        /*
        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        inicializarAdaptador();
        */
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascota) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

    /*
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
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

}
