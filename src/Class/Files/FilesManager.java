package Class.Files;

import Class.Datas.DataEntry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FilesManager {

    private String file;

    public FilesManager() {
        this.file = "Data.csv";
    }

    public void save_txt(DataEntry data, JFileChooser jf) {
        FileWriter fw;
        PrintWriter pw;
        try {
            String[] dataTitles = {"Unidad de tiempo", "Tabla de eventos", "tiempo de simulacion", "cantidad de clientes",
                "Cantidad de servidores", "costo del tiempo en servicio del cliente", "Costo de tiempo de espera del cliente",
                "Costo del servidor ocupado", "costo del servidor desocupado", "costo del tiempo extra del servidor",
                "costo normal de la operacion", "costo de operacion extra", "Probabilidad", "intervalo Desde", "Intervalo Hasta"};
            fw = new FileWriter(jf.getCurrentDirectory() + "/" + file);
            pw = new PrintWriter(fw);

//            for (int i = 0; i < rp.cantidadRegistro(); i++) {
//                p = rp.obtenerRegistro(i);
//                pw.println(String.valueOf(p.getCodigo() + ", " + p.getNombre() + ", " + p.getPrecio() + ", " + p.getDescripcion()));
//            }
            for (int i = 0; i < dataTitles.length - 3; i++) {
                pw.print(dataTitles[i] + ";");
            }
            pw.println();
            pw.println(data.getTimeUnit() + " ;" + data.getEventTable() + " ;" + data.getTimeSimulation() + " ;" + data.getQuantityCustomers() + " ;"
                    + data.getQuantityServers() + " ;" + data.getCostTimeCustomer() + " ;" + data.getCostTimeWaitCustomer() + " ;" + data.getBusyServercost() + " ;"
                    + data.getIdleServerCost() + " ;" + data.getExtraTimeServerCost() + " ;" + data.getCostNormalOperation() + " ;" + data.getExtraOperationCost() + " ;");
            pw.println();

            //Here you can write the customers arrived table
            for (int i = 12; i < 15; i++) {
                pw.print(dataTitles[i] + ";"); //Titles
            }
            pw.println();
            for (int i = 0; i < data.getArrivedCustomers().getRowCount(); i++) {
                //Values
                pw.println(data.getArrivedCustomers().getValueAt(i, 1) + ";" + data.getArrivedCustomers().getValueAt(i, 2) + ";" + data.getArrivedCustomers().getValueAt(i, 3) + ";");
            }
            pw.println();
            //Here you can read the service time table
            for (int i = 12; i < 15; i++) {
                pw.print(dataTitles[i] + ";");//Titles
            }
            pw.println();
            for (int i = 0; i < data.getServiceTime().getRowCount(); i++) {
                //Values
                pw.println(data.getServiceTime().getValueAt(i, 1) + ";" + data.getServiceTime().getValueAt(i, 2) + ";" + data.getServiceTime().getValueAt(i, 3));
            }

            pw.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al grabar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }

    public DataEntry readText(String file) {
        DataEntry data = new DataEntry();
        
        File ruta = new File(file);
        try {

            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);

            
            String linea = bu.readLine();
            
            while (!(linea = bu.readLine()).contains("Probabilidad")) {
                StringTokenizer st = new StringTokenizer(linea, ";");
                data.setTimeUnit(st.nextToken());
                data.setEventTable((st.nextToken()));
                data.setTimeSimulation(Double.parseDouble(st.nextToken()));
            }
            while (!(linea = bu.readLine()).contains("Probabilidad")) {
                System.out.println(linea);
            }
            while ((linea = bu.readLine())!=null) {
                System.out.println(linea);
            }
            
            bu.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
        return data;
    }

}
