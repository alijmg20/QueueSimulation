
package views.Simulation;

import Class.Datas.DataEntry;
import Class.Datas.DataOut;
import Class.Simulation.Simulation;
import javax.swing.JOptionPane;


public class SimulationView extends javax.swing.JInternalFrame {

    private DataEntry data;
    Simulation simulation;
    DataOut dataOut;
    public SimulationView() {
        initComponents();
    }
    public SimulationView(DataEntry data) {
        initComponents();
        this.data = data;
        simulation = new Simulation(data);
        dataOut = simulation.process();
        this.tableSimulation.setModel(dataOut.getEventTable());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSimulation = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Ventana de simulacion");

        jScrollPane1.setViewportView(tableSimulation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSimulation;
    // End of variables declaration//GEN-END:variables
}
