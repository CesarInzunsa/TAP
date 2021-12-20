
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author cesar
 */
public class HiloContador extends Thread{

    int i = 1;
    NewJFrame puntero;
    DefaultTableModel tablaPersona;
    
    public HiloContador(NewJFrame direccion, DefaultTableModel tablaPersona){
        this.puntero = direccion;
        this.tablaPersona = tablaPersona;
    }
    
    @Override
    public void run() {
        super.run();
        //Codigo que se ejecuta en 2do plano, pero solo se ejecutara una sola vez
        
        //puntero.setTitle("HILO CONTADOR: "+i);
        //i++;
        
        //para forzar el hilo para mantenerlo en ejecucion en 2do plano indefinidamente
        
        
        ArrayList<String> lista = new ArrayList<String>();
        
        for (int i = 0; i < tablaPersona.getRowCount(); i++) {
            if (Integer.parseInt(tablaPersona.getValueAt(i, 4).toString()) >= 18) {
               lista.add(tablaPersona.getValueAt(i, 2).toString()); 
            }
        }
        
        DefaultListModel modelo = new DefaultListModel();
        modelo.addAll(lista);
        
        puntero.jList1.setModel(modelo);
        
        
        
        
        while(true){
            puntero.setTitle("HILO CONTADOR: "+i);
            i++;
            
            //aprender como evitar que sea inestable el hilo
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloContador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
}
