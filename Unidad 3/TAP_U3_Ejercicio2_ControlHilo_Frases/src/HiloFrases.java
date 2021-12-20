
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author cesar
 */
public class HiloFrases extends Thread{

    private Ventana puntero;
    private boolean ejecutar = true;
    private String[] frases = {"EL RESPETO AL DERECHO AJENO ES LA PAZ","HOMBRES NECIOS QUE ACUSAIS A LA MUJER SIN RAZON","SUFRAGIO EFECTIVO NO REELECCIÓN","PIES... ¿PARA QUE LOS QUIERO SI TENGO ALAS?","A LA VIBORA VIBORA DE LA MAR... POR AQUI PUEDEN PASAR"};
    private int indice = 0;
    private boolean despausado = true;
    
    public HiloFrases(Ventana p){
        this.puntero = p;
    }
    
    public void pausar(){
        despausado = !despausado;
    }
    
    @Override
    public void run() {
        super.run();
        
        while(ejecutar){
            try {
                
                if (despausado){
                    puntero.jLabel1.setText(frases[indice]);
                    indice++;
                    if (indice == 5) {
                        indice = 0;
                    }
                
                    sleep(1900);
                }
                sleep(100);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloFrases.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public boolean isEjecutar() {
        return ejecutar;
    }

    public void setEjecutar(boolean ejecutar) {
        this.ejecutar = ejecutar;
    }
    
    
    
}
