
package views.Simulation;

import Class.Datas.DataEntry;
import javax.swing.JOptionPane;


public class SimulationView extends javax.swing.JInternalFrame {

    private DataEntry data;
    
    public SimulationView() {
        initComponents();
    }
    public SimulationView(DataEntry data) {
        initComponents();
        this.data = data;
        JOptionPane.showMessageDialog(null,"La cantidad de clientes son: " +this.data.getQuantityCustomers());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setTitle("Ventana de simulacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
