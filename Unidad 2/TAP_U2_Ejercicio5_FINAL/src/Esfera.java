
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author cesar
 */
public class Esfera {
    /*
    CADA ESFERA TIENE UN X, Y. AL INICIAR TIENE UN TAMAÑO Y COLOR DIFERENTE C/U
        AL INICIAR TOMAN UN CAMINO DIFERENTE (1 DE 4).
        LAS ESFERAS MAS GRANDES CAMINAN MAS LENTO
        LAS ESFERAS MAS PEQUEÑAS SON MÁS ÁGILES.
        LA CANTIDAD DE ESPERAS ES VARIABLE.
        LAS ESFERAS REBOTAN EN LA PANTALLA
    */
    
    /*
    1 derecha
    2 izquierda
    3 arriba
    4 abajo
    */
    int x = 0;
    int y = 0;
    int tam = 0;
    Color color = Color.BLUE;
    int direccion = 0;
    int desplazamientoX = 10;
    int desplazamientoY = 10;
    
    public Esfera(){
        x = (int) (Math.random()*700)+1;
        y = (int) (Math.random()*300)+1; 
        tam = (int) (Math.random()*30)+1;
        direccion = (int) (Math.random()*4)+1;
    }
    
    public void moverEsfera(){  
        
        //arriba
        if (direccion == 1) {
            desplazamientoY *=-1;
        }
        //abajo
        if (direccion == 2) {
            desplazamientoY *=-1;
        }
        
        x += desplazamientoX;
        if (x>=680) {
            desplazamientoX *=-1;
        }
        if (x<=0) {
            desplazamientoX *=-1;
        }
        y += desplazamientoY;
        if (y>=280) {
            desplazamientoY*=-1;
        }
        if (y<=0) {
            desplazamientoY *=-1;
        }
    }
    
    public void dibujarEsfera(Graphics g){
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B = (int)(Math.random()*256);
        
        Color ramdomColor = new Color(R, G, B);
        
        g.setColor(ramdomColor);
        g.fillOval(x, y, tam, tam);
    }
    
}
