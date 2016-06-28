package lexgame.com.petragramcursocoursera.presentador;

import android.content.Context;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.fragments.PerfilFragment;
import lexgame.com.petragramcursocoursera.fragments.PerfilFragmentI;
import lexgame.com.petragramcursocoursera.model.ConstructorMascota;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 27/06/2016.
 */
public class PerfilFragmentPresenter implements PerfilFragmentPresenterI {

    private PerfilFragmentI perfilFragment;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> likes;
    private Mascota mas;

    public PerfilFragmentPresenter(PerfilFragment perfilFragment, Context context){
        this.perfilFragment = perfilFragment;
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
        perfilFragment.inicializarAdaptadorRV(perfilFragment.crearAdaptador(mascotas));
        perfilFragment.generarGridLayout();
    }
}
