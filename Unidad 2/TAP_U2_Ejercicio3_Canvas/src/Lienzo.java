
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/*
 * LO QUE HACE EL CANVAS, GENERA UN OBJETO QUE PERMITE USAR PRIMITIVAS DE DIBUJO
 * TAMBIEN SE LE CONOCE COMO DIBUJO DE NIVEL BAJO O MEDIOS.
 * 
 * DRAW = CONTORNO
 * FILL = RELLENO
 */

/**
 *
 * @author cesar
 */
public class Lienzo extends Canvas implements MouseListener, MouseMotionListener{
    
    Image icono1 = new ImageIcon(getClass().getResource("/Imagenes/icono1.PNG")).getImage();
    Image icono2 = new ImageIcon(getClass().getResource("/Imagenes/icono2.PNG")).getImage();
    int icon1X = 400;
    int icon1Y = 50;
    int icon2X = 500;
    int icon2Y = 50;
    int desplazamientoX = 5;
    int desplazamientoY = 5;
    
    int txtX = 100;
    int desplazamientotxtX = 20;
    
    Timer t = new Timer(50, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            icon1X += desplazamientoX;
            if (icon1X>=1334 || icon1X<=0) {
                desplazamientoX *=-1;
            }
            
            icon1Y += desplazamientoY;
            if (icon1Y>=736 || icon1Y<=0) {
                desplazamientoY *=-1;
            }
            
            txtX += desplazamientotxtX;
            if(txtX>=1220 || txtX<=0) {
                desplazamientotxtX *=-1;
            }
            
            repaint();//vuelve a llamar al metodo paint
        }
    });
    
    
    
    public Lienzo(){
        
        
        //ACTIVAR EL OYENTE
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)g;
        
        
        //Texto
        this.setBackground(Color.DARK_GRAY);
        
        g.setColor(Color.BLUE);
        g.setFont(new Font("ARIAL",Font.PLAIN,25));
        g.drawString("Cesar Inzunsa", txtX, 50);
        
        g2.setStroke(new BasicStroke(10)); //contorno
        
        //circulo
        g2.setBackground(Color.RED);
        g2.fillOval(400, 150, 80, 80);
        g2.setColor(Color.WHITE);
        g2.drawOval(400, 150, 80, 80);
        
        
        //rectangulo
        g2.setColor(Color.ORANGE);
        
        g2.fillRect(100,200,200,120);
        g2.setColor(Color.MAGENTA);
        g2.drawRect(100,200,200,120);
        
        g2.setStroke(new BasicStroke(5)); //grosor del contorno
        g2.setColor(Color.CYAN);
        g2.drawLine(0,0,getWidth(),getHeight());//contorno
        
        g2.drawImage(icono1,icon1X,icon1Y,this);
        g2.drawImage(icono2,500,50,this);
        
        //AGREGA UN RECTANGULO DE PUNTAS REDONDEAS
        //AGREGA UN CUADRADO
        //AGREGA UN OVALO DE 400,200
        g2.setColor(Color.RED);
        g2.fillRoundRect(400, 400, 200, 120, 20, 20);
        
        
        g2.setColor(Color.white);
        g2.fillRect(800, 400, 50, 50);
        
        
        g2.setColor(Color.lightGray);
        g2.fillOval(600, 10, 400, 200);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        t.start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        icon2X = e.getX()-icono2.getWidth(this)/2;
        icon2Y = e.getY()-icono2.getHeight(this)/2;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    
}
