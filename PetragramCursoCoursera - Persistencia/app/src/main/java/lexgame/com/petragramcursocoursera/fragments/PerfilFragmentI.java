package lexgame.com.petragramcursocoursera.fragments;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.adapter.MascotaAdaptador;
import lexgame.com.petragramcursocoursera.adapter.MascotaPerfilAdaptador;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 27/06/2016.
 */
public interface PerfilFragmentI {

    public void generarGridLayout();

    public MascotaPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascota);

    public void inicializarAdaptadorRV(MascotaPerfilAdaptador adaptador);
}
