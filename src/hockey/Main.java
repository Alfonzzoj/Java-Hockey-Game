/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hockey;

import javax.swing.JFrame;

/**
 * 
 * @author Alfonzzoj
 */
public class Main {

    final static int ANCHURA = 1000;
    final static int ALTURA  = 500;

    public Main() {
        JFrame ventana = new JFrame();
        ventana.setSize(ANCHURA,ALTURA);
        ventana.setBounds(0,0,ANCHURA,ALTURA);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("AirHockey - Jesus Alfonzo | Luis Amarista ");
        
        Gameplay gameplay = new Gameplay();
        ventana.add(gameplay);
        
    }
    public static void main(String[] args){
        new Main();
    }
    
    
    
    
    
}
