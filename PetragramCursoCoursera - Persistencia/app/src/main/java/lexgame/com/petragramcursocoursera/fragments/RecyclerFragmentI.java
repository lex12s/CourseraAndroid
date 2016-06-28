package lexgame.com.petragramcursocoursera.fragments;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.adapter.MascotaAdaptador;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 26/06/2016.
 */
public interface RecyclerFragmentI {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
