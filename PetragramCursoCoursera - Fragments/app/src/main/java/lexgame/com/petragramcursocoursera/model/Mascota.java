package lexgame.com.petragramcursocoursera.model;

/**
 * Created by Conba on 25/06/2016.
 */
public class Mascota {


    private String nombre;
    private int likes;
    private int image;

    public Mascota(String nombre, int likes, int image) {
        this.nombre = nombre;
        this.likes = likes;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
