package lexgame.com.petragramcursocoursera.presentador;

import android.content.Context;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.activity.TopMascotasActivity;
import lexgame.com.petragramcursocoursera.activity.TopMascotasActivityI;
import lexgame.com.petragramcursocoursera.model.ConstructorMascota;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 27/06/2016.
 */
public class TopMascotasActivityPresenter implements TopMascotasActivityPresenterI {

    private TopMascotasActivityI topMascotasActivity;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public TopMascotasActivityPresenter(TopMascotasActivity topMascotasActivity, Context context){
        this.topMascotasActivity = topMascotasActivity;
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
        topMascotasActivity.inicializarAdaptadorRV(topMascotasActivity.crearAdaptador(mascotas));
        topMascotasActivity.generarLinearLayoutVertical();
    }
}
