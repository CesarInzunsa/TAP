
import java.awt.Canvas;
import java.awt.Graphics;
/**
 *
 * @author cesar
 */
public class Lienzo extends Canvas{

    Carrito carrito1;
    Carrito carrito2;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        carrito1 = new Carrito(300, 300, 2);
        carrito1.dibujarCarrito(g);
        
        carrito2 = new Carrito(10, 10, 1);
        carrito2.dibujarCarrito(g);
    }
    
}
