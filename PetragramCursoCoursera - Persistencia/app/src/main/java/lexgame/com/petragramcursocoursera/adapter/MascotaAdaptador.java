package lexgame.com.petragramcursocoursera.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.model.ConstructorMascota;
import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 25/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascota, Activity activity) {
        this.mascotas = mascota;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cadrview_mascota,parent,false);
        return  new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.nombreMascota.setText(mascota.getNombre());
        holder.likeMascota.setText(String.valueOf(mascota.getLikes()));
        holder.fotoMascota.setImageResource(mascota.getImage());

        holder.imgLikeMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascota constructor = new ConstructorMascota(activity);
                constructor.darLikeMascota(mascota);
                holder.likeMascota.setText(constructor.obtenerLikeMscota(mascota)+ " ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoMascota;
        private TextView nombreMascota;
        private TextView likeMascota;
        private ImageView imgLikeMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            fotoMascota         = (ImageView) itemView.findViewById(R.id.fotoMascota);
            nombreMascota       = (TextView) itemView.findViewById(R.id.nombreMascota);
            likeMascota         = (TextView) itemView.findViewById(R.id.likeCantidad);
            imgLikeMascota      = (ImageView) itemView.findViewById(R.id.iconLikeMascota);
        }
    }
}
