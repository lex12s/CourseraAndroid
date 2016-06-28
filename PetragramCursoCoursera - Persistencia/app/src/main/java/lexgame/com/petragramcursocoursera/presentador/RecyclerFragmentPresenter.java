package lexgame.com.petragramcursocoursera.presentador;

import android.content.Context;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.fragments.RecyclerFragment;
import lexgame.com.petragramcursocoursera.fragments.RecyclerFragmentI;
import lexgame.com.petragramcursocoursera.model.ConstructorMascota;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 26/06/2016.
 */
public class RecyclerFragmentPresenter implements RecyclerFragmentPresenterI {

    private RecyclerFragmentI recyclerFragment;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public RecyclerFragmentPresenter(RecyclerFragment recyclerFragment, Context context){
        this.recyclerFragment = recyclerFragment;
        this.context = context;
        obtenerMascota();
    }

    @Override
    public void obtenerMascota() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerMascota();
        mostrarMascotaRV();
    }

    @Override
    public void mostrarMascotaRV() {
        recyclerFragment.inicializarAdaptadorRV(recyclerFragment.crearAdaptador(mascotas));
        recyclerFragment.generarLinearLayoutVertical();
    }
}
