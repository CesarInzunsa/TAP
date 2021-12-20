
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
/**
 *
 * @author cesar
 */
public class Lienzo extends Canvas{
    Image santa = new ImageIcon(getClass().getResource("/santa.png")).getImage();
    
    int imgX = 100;
    int lunax1 = 20;
    int lunax2 = 17;
    int incrementoLuna = 0;
    Copo[] nieve = new Copo[300];
    
    Timer movimiento = new Timer(50, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            imgX -= 5;
            if (imgX<-500) {
                imgX = (int) (Math.random()*200)+1400;
            }
            
            incrementoLuna += 10;
            if (incrementoLuna>1400) {
                incrementoLuna *=-1;
            }
        }
    });
    
    Timer caidaNieve = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Copo copo:nieve) {
                copo.moverCopo();
            }
            repaint();
        }
    });
    
    public Lienzo(){
        movimiento.start();
        for (int i = 0; i < nieve.length; i++) {
            nieve[i] = new Copo();
        }
        caidaNieve.start();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g1 = (Graphics2D)g; //Luna
        Graphics2D g2 = (Graphics2D)g; //Montaña 1
        Graphics2D g3 = (Graphics2D)g; //Montaña 2
        Graphics2D g4 = (Graphics2D)g; //Arbol 1
        Graphics2D g5 = (Graphics2D)g; //Arbol 2
        Graphics2D g6 = (Graphics2D)g; //Casa
        Graphics2D g7 = (Graphics2D)g; //Imagen
        
        this.setBackground(Color.BLUE);
        
        //Luna
        g1.setColor(Color.WHITE);
        g1.fillOval(200+incrementoLuna, 20, 80, 80);
        g1.setColor(Color.BLUE);
        g1.fillOval(230+incrementoLuna, 17, 55, 55);
        
        //Borde de las montañas
        g2.setStroke(new BasicStroke(5));
        
        //Montaña 1
        g2.setColor(Color.WHITE);
        g2.fillOval(-300, 430, 1200, 800);
        g2.setColor(Color.CYAN);
        g2.drawOval(-300, 430, 1200, 800);
        
        //Montaña 2
        g3.setColor(Color.WHITE);
        g3.fillOval(500, 340, 1200, 800);
        g3.setColor(Color.CYAN);
        g3.drawOval(500, 340, 1200, 800);
        
        Color cafe = new Color(128,64,0);
        //Arbol 1
        g4.setColor(cafe);
        g4.fillRect(320, 450, 25, 50);
        g4.setColor(Color.GREEN);
        g4.fillOval(303, 430, 60, 40);
        g4.fillOval(303, 405, 60, 40);
        
        //Arbol 2
        g5.setColor(cafe);
        g5.fillRect(800, 460, 50, 100);
        g5.setColor(Color.GREEN);
        g5.fillOval(765, 365, 120, 80);
        g5.fillOval(765, 415, 120, 80);
        
        //Casa
        g6.setColor(cafe);
        g6.fillRect(1080, 300, 200, 100);
        g6.setColor(Color.YELLOW);
        g6.fillRect(1120, 350, 30, 50);
        
        g6.setColor(Color.RED);
        int[] xPoints = {1055,1090,1260,1295};
        int[] yPoints = {310,270,270,310};
        g6.fillPolygon(xPoints, yPoints, 4);
        
        
        g7.drawImage(santa, imgX,150, this);
        
        g2.setColor(Color.WHITE);
        for (Copo c: nieve) {
            c.pintarCopo(g);
            //g.fillOval(c.x, c.y, c.tam, c.tam);
        }
    }
    
}
