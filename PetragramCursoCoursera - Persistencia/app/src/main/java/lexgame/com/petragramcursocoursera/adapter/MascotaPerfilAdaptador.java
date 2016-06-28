package lexgame.com.petragramcursocoursera.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 25/06/2016.
 */
public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaViewHolder>{

    private ArrayList<Mascota> mascota;
    private Activity activity;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascota, Activity activity) {
        this.mascota = mascota;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cadrview_mascota_perfil,parent,false);
        return  new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascotas = mascota.get(position);

        holder.likeMascota.setText(String.valueOf(mascotas.getLikes()));
        holder.fotoMascota.setImageResource(mascotas.getImage());
    }

    @Override
    public int getItemCount() {
        return mascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoMascota;
        private TextView likeMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            fotoMascota         = (ImageView) itemView.findViewById(R.id.fotoMascotaPerfil);
            likeMascota         = (TextView) itemView.findViewById(R.id.likeCantidadPerfil);
        }
    }
}
