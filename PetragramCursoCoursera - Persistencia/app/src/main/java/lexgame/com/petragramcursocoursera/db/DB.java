package lexgame.com.petragramcursocoursera.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import lexgame.com.petragramcursocoursera.model.Mascota;

/**
 * Created by Conba on 26/06/2016.
 */
public class DB extends SQLiteOpenHelper {

    Context context;

    public DB(Context context) {
        super(context, ConstantesDB.DATABASE_NAME, null, ConstantesDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryTablaMascota = "CREATE TABLE " + ConstantesDB.TABLE_MASCOTA + " ( " +
                ConstantesDB.TABLE_MASCOTA_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_MASCOTA_NOMBRE       + " TEXT, " +
                ConstantesDB.TABLE_MASCOTA_FOTO         + " INTEGER " +
                " )";

        String queryTablaLikes = "CREATE TABLE " + ConstantesDB.TABLE_MASCOTA_LIKE + " ( " +
                ConstantesDB.TABLE_MASCOTA_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_MASCOTA_LIKE_ID_MASCOTA  + " INTEGER, " +
                ConstantesDB.TABLE_MASCTOA_LIKE_NUMERO_LIKE + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesDB.TABLE_MASCOTA_LIKE_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesDB.TABLE_MASCOTA + "(" + ConstantesDB.TABLE_MASCOTA_LIKE_ID_MASCOTA + ")" +
                ")";

        db.execSQL(queryTablaMascota);
        db.execSQL(queryTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesDB.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesDB.TABLE_MASCOTA_LIKE);
        onCreate(db);
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_MASCOTA_LIKE, null, contentValues);
        db.close();
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesDB.TABLE_MASCTOA_LIKE_NUMERO_LIKE+")" +
                " FROM " + ConstantesDB.TABLE_MASCOTA_LIKE +
                " WHERE " + ConstantesDB.TABLE_MASCOTA_LIKE_ID_MASCOTA + "="+ mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public ArrayList<Mascota> obtenerTodasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesDB.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImage(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesDB.TABLE_MASCTOA_LIKE_NUMERO_LIKE+") as likes " +
                    " FROM " + ConstantesDB.TABLE_MASCOTA_LIKE +
                    " WHERE " + ConstantesDB.TABLE_MASCOTA_LIKE_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }
}
