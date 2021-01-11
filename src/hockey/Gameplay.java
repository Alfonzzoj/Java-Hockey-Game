/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hockey;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Alfonzzoj
 */
public class Gameplay extends JPanel implements KeyListener,ActionListener{

    private static final long serialVersionUID= 1L;
    //=======================G A M E P L A Y ===========================
    private boolean juego = false;
    private boolean gameover=false;

    private Timer timer;
    
    private int multiplicador = 2;
    private int tiempo = 4*multiplicador;
    
    private int score1 =0;
    private int score2 =0;

    
    //=======================J U G A D O R E S =========================    
    private int jugador1X=5;
    private int jugador1Y=Main.ALTURA/2-75;

    private int jugador2X=Main.ANCHURA-25;
    private int jugador2Y=Main.ALTURA/2-75;



        //======M O V I M I E N T O S======//
        private boolean up1  =false;
        private boolean down1=false;
        private boolean up2  =false;    
        private boolean down2=false;

    //=======================P E L O T A ===============================
    private int dirPelotaX =2*multiplicador;
    private int dirPelotaY =3*multiplicador;
    private int posPelotaX=200;
    private int posPelotaY=300;

    private int anchuraPelota=20;
    private int alturaPelota =20;


    
    
    //Constructor
    public Gameplay() {
        timer = new Timer(tiempo,this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }
    
    //Metodo paint para mostrar cosas en pantalla
    public void paint(Graphics g){
        moverPelota();
        moverJugadores();
        colisiones();
        //background
        g.setColor(Color.BLACK);
        g.fillRect(0 , 0, Main.ANCHURA, Main.ALTURA);
        
        //Jugador 1
        g.setColor(Color.white);
        g.fillRect(jugador1X, jugador1Y, 15, 100);
        
        //Jugador 2
        g.setColor(Color.white);
        g.fillRect(jugador2X, jugador2Y, 15, 100);
        //Pelota
        g.setColor(Color.white);
        g.fillOval(posPelotaX, posPelotaY, anchuraPelota, alturaPelota);
        //Puntuacion 
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,22));
        g.drawString("Score 1: "+score1, 30, 20);
        g.drawString("Score 2: "+score2, 860, 20);
        //Mensaje de inicio 
        if (!juego && !gameover) {
            g.drawString("Presione ENTER para iniciar", 340, 150);
        }
        if (gameover) {
            /*if (score1==score2) {
            //EMPATE            
                g.drawString("EMPATE", 470, 130);
            }else if (score1>score2 ) {
            //Jugador uno 
                g.drawString("Jugador 1 Wins", 415, 130);
            }else  {
                g.drawString("Jugador 2 Wins", 415, 130);
            }*/
            g.drawString("Presione ENTER para reiniciar ", 340, 190);

        }


    }
    
    //Permite el movimiento de la pelota
    public void moverPelota(){
        //Si se estta jugando 
        if (juego) {
            posPelotaX+=dirPelotaX;
            posPelotaY+=dirPelotaY;
            if (posPelotaX>1000-30) {
                gameover();
            }if (posPelotaX<0) {
                gameover();                
            }if (posPelotaY<0) {
                dirPelotaY = -dirPelotaY;
            }if (posPelotaY>500-50) {
                dirPelotaY = -dirPelotaY;
            }
        }
 
    }
    
    //Permite el movimiento de los jugadores
    public void moverJugadores(){
        if (juego) {
            //Jugador 1
                if (up1) {
                    if (jugador1Y<10) {
                        jugador1Y =10;
                    }else
                        jugador1Y-=3;
                }
                if (down1) {
                    if (jugador1Y>360) {
                        jugador1Y =360;
                    }else
                        jugador1Y+=3;  
                }
            //Jugador 2 
                if (up2) {
                    if (jugador2Y<10) {
                        jugador2Y =10;
                    }else
                        jugador2Y-=3;
                }
                if (down2) {
                    if (jugador2Y>360) {
                        jugador2Y =360;
                    }else
                        jugador2Y+=3;  
                }
        }
    }

    //Permite las colisiones de los jugadores con la pelota
    public void colisiones(){
        if (new Rectangle(posPelotaX,posPelotaY,anchuraPelota,alturaPelota).intersects(new Rectangle(jugador1X,jugador1Y,15,100))) {
            dirPelotaX= -dirPelotaX;
            score1++;
        }
        if (new Rectangle(posPelotaX,posPelotaY,anchuraPelota,alturaPelota).intersects(new Rectangle(jugador2X,jugador2Y,15,100))) {
            dirPelotaX= -dirPelotaX;
            score2++;
        }
    }
    
    //Detiene la partida al anotar y reinicia el juego
    public void reiniciar(){
        //=======================G A M E P L A Y ===========================
        juego = true;
        gameover=false;
        score1 =0;
        score2 =0;
        //=======================J U G A D O R E S =========================    
        jugador1X=5;
        jugador1Y=Main.ALTURA/2-75;
        jugador2X=Main.ANCHURA-25;
        jugador2Y=Main.ALTURA/2-75;
        //======M O V I M I E N T O S======//
        up1  =false;
        down1=false;
        up2  =false;    
        down2=false;
        //=======================P E L O T A ===============================
        posPelotaX=200;
        posPelotaY=300;
        dirPelotaX =2*multiplicador;
        dirPelotaY =3*multiplicador;
        timer.start();
    }
    
    //Finaliza el juego
    public void gameover(){
        gameover=true;
        juego=false;
        timer.stop();
    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        timer.start();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //Movimiento Jugador 1
            //Arriba
            if (e.getKeyCode()==KeyEvent.VK_W) {
                up1=true;
            }
            //Abajo
            if (e.getKeyCode()==KeyEvent.VK_S) {
                down1=true;
            }
        //Movimiento Jugador 2 
            //Arriba
            if (e.getKeyCode()==KeyEvent.VK_UP) {
                up2=true;
            }
            //Abajo
            if (e.getKeyCode()==KeyEvent.VK_DOWN) {
                down2=true;
            }
        //Inicio de juego 
        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
           juego=true;
            if (gameover) {
                reiniciar();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //Movimiento Jugador 1
            //Arriba
            if (e.getKeyCode()==KeyEvent.VK_W) {
                up1=false;
            }
            //Abajo
            if (e.getKeyCode()==KeyEvent.VK_S) {
                down1=false;
            }
        //Movimiento Jugador 2 
            //Arriba
            if (e.getKeyCode()==KeyEvent.VK_UP) {
                up2=false;
            }
            //Abajo
            if (e.getKeyCode()==KeyEvent.VK_DOWN) {
                down2=false;
            }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

}
