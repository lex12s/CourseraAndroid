package lexgame.com.petragramcursocoursera.model;

/**
 * Created by Conba on 25/06/2016.
 */
public class Mascota implements Comparable{


    private int id;
    private String nombre;
    private int likes;
    private int image;


    public Mascota(String nombre, int likes, int image) {
        this.nombre = nombre;
        this.likes = likes;
        this.image = image;
    }

    public Mascota(){

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object another) { //sobrecarga del metodos compareTo
        //http://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/

        int compareRating= ((Mascota)another).getLikes();

        //orden ascendente
        //return this.ranting-compareRating;

        //orden decendente
        return compareRating-this.likes;
    }


}
