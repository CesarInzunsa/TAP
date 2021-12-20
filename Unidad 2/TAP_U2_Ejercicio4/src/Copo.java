
import java.awt.Graphics;
/**
 *
 * @author cesar
 */
public class Copo {
    int x = 0;
    int y = 0;
    int tam = 0;
    
    public Copo(){
        x = (int) (Math.random()*600)+1;
        y = (int) (Math.random()*1000)*-1;
        tam = (int) (Math.random()*5)*-1;
    }
    
    public void moverCopo(){
        y += tam;
        if (y>500) {
            y = (int) (Math.random()*1000)*-1;
        }
    }
    
    public void pintarCopo(Graphics g){
        g.fillOval(x, y, tam, tam);
    }
}
