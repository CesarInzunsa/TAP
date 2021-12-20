
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author cesar
 */
public class Carrito {
    int x;
    int y;
    int orientacion;
    /*
        2 --> vertical
        1 --> horizontal
    */
    public Carrito(int x, int y, int orientacion){
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
    }
    
    public void dibujarCarrito(Graphics g){
        if (orientacion == 1) {
            dibujarHorizontal(g);
        }
        if (orientacion == 2) {
            dibujarVertical(g);
        }
    }
    
    
    private void dibujarHorizontal(Graphics g){
        /*
            x --> 10
            y --> 10
         */
        Color a = new Color(132, 175, 187);
        Color b = new Color(108, 144, 152);
        
        g.setColor(a);
        g.fillRect(x, y, 100, 50);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x+10, y+50, 20, 5, 5, 5);
        g.fillRoundRect(x+60, y+50, 20, 5, 5, 5);
        g.fillRoundRect(x+10, y-5, 20, 5, 5, 5);
        g.fillRoundRect(x+60, y-5, 20, 5, 5, 5);
        g.setColor(Color.WHITE);
        g.fillRect(x+25, y+5, 60, 40);
        g.setColor(b);
        g.fillRect(x+40, y+5, 35, 40);
        g.setColor(Color.WHITE);
        g.fillRect(x+9, y+33, 7, 7);
        g.fillRect(x+9, y+10, 7, 7);
    }
    
    private void dibujarVertical(Graphics g){
        
        /*
            x --> 300
            y --> 300
        */
        Color a = new Color(132, 175, 187);
        Color b = new Color(108, 144, 152);
        
        g.setColor(a);
        g.fillRect(x, y, 50, 100);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-5, y+60, 5, 20, 5, 5);
        g.fillRoundRect(x+50, y+60, 5, 20, 5, 5);
        g.fillRoundRect(x-5, y+10, 5, 20, 5, 5);
        g.fillRoundRect(x+50, y+10, 5, 20, 5, 5);
        g.setColor(Color.WHITE);
        g.fillRect(x+5, y+25, 40, 60);
        g.setColor(b);
        g.fillRect(x+5, y+40, 40, 35);
        g.setColor(Color.WHITE);
        g.fillRect(x+33, y+9, 7, 7);
        g.fillRect(x+10, y+9, 7, 7);
    }
    
}
