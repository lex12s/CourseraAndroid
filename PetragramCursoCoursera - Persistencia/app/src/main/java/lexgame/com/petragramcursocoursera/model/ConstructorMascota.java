package lexgame.com.petragramcursocoursera.model;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.db.ConstantesDB;
import lexgame.com.petragramcursocoursera.db.DB;

/**
 * Created by Conba on 26/06/2016.
 */
public class ConstructorMascota {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascota(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascota(){
        DB db = new DB(context);
        insertarMascota(db);
        return db.obtenerTodasMascotas();
    }

    public void insertarMascota(DB db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesDB.TABLE_MASCOTA_NOMBRE,"MIKE");
        contentValues.put(ConstantesDB.TABLE_MASCOTA_FOTO, R.drawable.dog1);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesDB.TABLE_MASCOTA_NOMBRE,"SUSY");
        contentValues.put(ConstantesDB.TABLE_MASCOTA_FOTO, R.drawable.dog2);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesDB.TABLE_MASCOTA_NOMBRE,"GOLIATH");
        contentValues.put(ConstantesDB.TABLE_MASCOTA_FOTO, R.drawable.dog3);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesDB.TABLE_MASCOTA_NOMBRE,"RIDICK");
        contentValues.put(ConstantesDB.TABLE_MASCOTA_FOTO, R.drawable.dog4);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesDB.TABLE_MASCOTA_NOMBRE,"COSITA");
        contentValues.put(ConstantesDB.TABLE_MASCOTA_FOTO, R.drawable.dog5);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        DB db = new DB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTA_LIKE_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesDB.TABLE_MASCTOA_LIKE_NUMERO_LIKE,LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikeMscota(Mascota mascota){
        DB db = new DB(context);
        return db.obtenerLikesContacto(mascota);
    }

}
