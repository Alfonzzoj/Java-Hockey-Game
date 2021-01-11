package hockey.Pelota;

/**
 * 
 * @author Jesus Alfonzo <Jesusalfonzo97@gmail.com>
 */
public class Pelota {
    static int idPelota;
    int anchura;
    int altura;

    public Pelota() {
        idPelota+=1;
        this.anchura = 20;
        this.altura = 30;
    }

    public static int getIdPelota() {
        return idPelota;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Pelota n:"+idPelota;
    }
    
    
    
    
}
