package lexgame.com.petragramcursocoursera.activity;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.adapter.MascotaAdaptador;
import lexgame.com.petragramcursocoursera.adapter.TopMascotaActivityAdaptador;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 27/06/2016.
 */
public interface TopMascotasActivityI {

    public void generarLinearLayoutVertical();

    public TopMascotaActivityAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(TopMascotaActivityAdaptador adaptador);
}
