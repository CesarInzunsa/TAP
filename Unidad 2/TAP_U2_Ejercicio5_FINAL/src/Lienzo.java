
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author cesar
 */
public class Lienzo extends Canvas{
    
    Esfera[] esferas = new Esfera[500];
    int desplazamientoY = 5;
    int desplazamientoX = 5;
    
    Timer movimiento = new Timer(10,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Esfera esfera:esferas){
                esfera.moverEsfera();
            }
            repaint();
        }
    });
    
    public Lienzo(){
        for (int i = 0; i < esferas.length; i++) {
            esferas[i] = new Esfera();
        }
        movimiento.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        for (Esfera esfera:esferas) {
            esfera.dibujarEsfera(g);
        }
    }
    
}
