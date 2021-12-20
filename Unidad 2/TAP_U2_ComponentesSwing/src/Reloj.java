
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class Reloj extends javax.swing.JPanel implements Serializable{

    private Boolean formato12 = true;
    
    Timer actualizador= new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar calendario = GregorianCalendar.getInstance();
            
            jLabel1.setText(obtenerHora(calendario));
            
        }
    });
    
        public void setColorLetra(Color color){
        jLabel1.setForeground(color);
    }
    
    public Color getColorLetra(){
        return jLabel1.getForeground();
    }
    
    public void setLetra(Font fuente){
        jLabel1.setFont(fuente);
    }
    
    public Font getLetra(){
        return jLabel1.getFont();
    }
    
    public void setFormato12(boolean valor){
        formato12 = valor;
    }
    
    public boolean getFormato12(){
        return formato12;
    }
    
    public String obtenerHora(Calendar calendario){
        String cad="", ultimo="";
        
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        if (formato12 == true) {
            ultimo = " AM";
            if (hora>12) {
                hora -= 12;
                ultimo = " PM";
            }
            if (hora>10) {
                cad+="0"+hora+":";
            }else{
                cad+=hora+":";
            }
        }else{
            if (hora<10) {
                cad+="0"+hora+":";
            }else{
                cad+=hora+":";
            }
        }
        
        
        int minuto = calendario.get(Calendar.MINUTE);
        if (minuto<10) {
            cad += "0"+minuto+":";
        }else{
            cad += minuto+":";
        }
        int segundo = calendario.get(Calendar.SECOND);
        if (segundo<10) {
            cad += "0"+segundo;
        }else{
            cad += segundo;
        }
        
        return cad+ultimo;
    }
    
    public Reloj() {
        initComponents();
        actualizador.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}