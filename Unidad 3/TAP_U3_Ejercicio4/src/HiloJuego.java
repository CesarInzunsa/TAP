
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author cesar
 */
public class HiloJuego extends Thread {

    private boolean terminar = true;
    private boolean iniciar_pausar = true;
    private Ventana puntero;
    private int tiros = 1;
    private String txt = "";
    private int puntos = 0;
    private JTextArea jTextArea;
    private int inicio = 0;
    private int espera = 0;

    public HiloJuego(Ventana puntero, JTextArea jTextArea, int inicio, int espera) {
        this.puntero = puntero;
        this.jTextArea = jTextArea;
        this.inicio = inicio;
        this.espera = espera;
    }

    @Override
    public void run() {
        super.run();

        try {
            HiloJuego.sleep(inicio);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (terminar) {
            try {
                jTextArea.setText(obtenerValoresDados());
                HiloJuego.sleep(espera);
                if (tiros == 2) {
                    terminar = false;
                    jTextArea.setText(obtenerPuntos());
                }
                tiros++;

            } catch (InterruptedException ex) {
                Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void pause() {
        this.iniciar_pausar = !this.iniciar_pausar;
    }

    private String obtenerValoresDados() {
        int dado1 = getNumeroAleatorioEntre(1, 6);
        int dado2 = getNumeroAleatorioEntre(1, 6);

        txt += "TIRO " + this.tiros + ":\nDado1: " + dado1 + "\nDado2: " + dado2 + "\n";
        puntos += dado1 + dado2;

        return txt;
    }

    private static int getNumeroAleatorioEntre(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo)) + minimo;
    }

    private String obtenerPuntos() {
        txt += "PUNTOS: " + puntos;
        return txt;
    }

    public int getPuntos() {
        return puntos;
    }
    
    public boolean getTiros(){
        return tiros == 2;
    }

}
