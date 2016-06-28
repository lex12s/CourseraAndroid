package lexgame.com.petragramcursocoursera.fragments;


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
import lexgame.com.petragramcursocoursera.model.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    ArrayList mascotas;
    RecyclerView listaMascotas;
    TextView nombre_perro;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_perfil);

        final GridLayoutManager glm= new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);
        listaMascotas.setHasFixedSize(true);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascota();
        inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascota(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Mike",5,R.drawable.dog1));
        mascotas.add(new Mascota("Goliath",5,R.drawable.dog2));
        mascotas.add(new Mascota("Susy",5,R.drawable.dog3));
        mascotas.add(new Mascota("Zeus",5,R.drawable.dog4));
        mascotas.add(new Mascota("Maris",5,R.drawable.dog5));
    }

}
