/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hockey.Jugador;

/**
 * 
 * @author Jesus Alfonzo <Jesusalfonzo97@gmail.com>
 */
public class Jugador {

    static int idJugador;
    private String nombre;
    private int    color;
    private int score;

    public Jugador(String nombre, int color) {
        idJugador+=1;
        this.nombre = nombre;
        this.color = color;
        this.score = 0;
    }

    public static int getIdJugador() {
        return idJugador;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "J"+idJugador + " " + nombre ;
    }
    
    
}
