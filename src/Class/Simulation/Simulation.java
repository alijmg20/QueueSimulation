package Class.Simulation;

import Class.Datas.ClientsData;
import Class.Datas.DataEntry;
import Class.Datas.DataOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class Simulation {

    private DataEntry data;

    
    
    // CAMBIAR TODO A ENTERO
    
    
    
    private int[] statusServers;
    private int waitingLength;
    private int timeModeling;
    private int arrivalTime;
    private int[] DepartureTime;
    private int eventNumber;
    private int arrivalNumber;
    private int departureNumber;
    private final int RANDOMNUMBER = 100;

    public Simulation(DataEntry data) {
        
        this.data = data;

        this.statusServers = new int[data.getQuantityServers()];
        for (int i = 0; i < data.getQuantityServers(); i++) {
            this.statusServers[i] = 0;
        }
        this.timeModeling = 0;
        this.arrivalTime = 0;
        this.DepartureTime = new int[data.getQuantityServers()];
        for (int i = 0; i < data.getQuantityServers(); i++) {
            this.DepartureTime[i] = 999999;
        }
        this.eventNumber = 0;
        this.arrivalNumber = 0;

    }

    public DataOut process() {

        Cliente client = new Cliente();
        Servidor servers = new Servidor(data);
        DataOut dataOut = new DataOut();
        String eventName = "condicion inicial";
        int number;
        DefaultTableModel eventModelTable = new DefaultTableModel(null, this.getTitles());

        eventModelTable.addRow(this.addRow(eventNumber, eventName, arrivalNumber, timeModeling,
                statusServers, this.waitingLength, arrivalTime, DepartureTime));
        int menorServidor = 0;
        do {
            menorServidor = this.menor(servers.timeTotals);
            if(arrivalTime < menorServidor){
            
                //LLEGADAAAAAAAAAAAAAAAAA
                
                this.timeModeling = this.arrivalTime;
                int j = 0;
                
                while(j < servers.data2.getQuantityServers()){
                    int i = 0;    
                    while(i <servers.data2.getQuantityServers()){
                        if(servers.ServerData[i][j].getServerInUse() == 0){
                            
                            
                            
                        }else{
                            
                        }
                    }
                }
            }
            
        } while (timeModeling < data.getTimeSimulation());
        dataOut.setEventTable(eventModelTable);
        return dataOut;
    }

    //OBTIENE LOS METODOS DINAMICAMENTE DE LA TABLA
    private String[] getTitles() {
        int ntitles = 4 + this.data.getQuantityServers() + 2 + this.DepartureTime.length;
        int contTitles = 0;
        String[] titles = new String[ntitles];
        titles[contTitles] = "Evento N°";
        contTitles++;
        titles[contTitles] = "tipo de Evento";
        contTitles++;
        titles[contTitles] = "N° Cliente";
        contTitles++;
        titles[contTitles] = "TM";
        contTitles++;
        for (int i = 0; i < this.data.getQuantityServers(); i++, contTitles++) {
            titles[contTitles] = "SS" + (i + 1);
        }
        titles[contTitles] = "WL";
        contTitles++;
        titles[contTitles] = "AT";
        contTitles++;

        for (int i = 0; i < this.DepartureTime.length; i++, contTitles++) {
            titles[contTitles] = "DT" + (i + 1);
        }
        return titles;
    } 
    
    //AÑADE UNA FILLA NUEVA A LA TABLA, DEBEMOS MODIFICARLA PARA CON LA NUEVA FORMA DE INGRESO
    private Object[] addRow(int eventNumber, String eventName, int number,
            int timeModeling, int[] statusServers, int waitingLenght, int arrivalTime, int[] departureTime) {

        ArrayList row = new ArrayList();

        row.add(eventNumber);
        row.add(eventName);
        row.add(number);
        row.add(timeModeling);
        for (int i = 0; i < statusServers.length; i++) {
            row.add(statusServers[i]);
        }
        row.add(waitingLenght);
        row.add(arrivalTime);
        for (int i = 0; i < statusServers.length; i++) {
            row.add(departureTime[i]);
        }
        return row.toArray();
    }
    
    //OBTIENE EL TIEMPO RANDOM TS
    private int getRandomTS(DefaultTableModel table) {
        Random rand = new Random();
        int timeRandom = rand.nextInt() * RANDOMNUMBER;
        int TS = 0;
        int acum = 0;
        int acum2 = (Integer.parseInt(table.getValueAt(0, 1).toString()));
        for (int k = 0; k < table.getRowCount(); k++) {

            if (timeRandom > acum
                    && timeRandom < acum2) {
                TS = Integer.parseInt(table.getValueAt(k, 0).toString());
                break;
            }

            acum += Integer.parseInt(table.getValueAt(k, 1).toString());
            acum2 += Integer.parseInt(table.getValueAt(k + 1, 1).toString());
        }
        return TS;
    }
    
    private int menor(int[] datos ){
        Arrays.sort(datos);
        return datos[0];
    }

//    private boolean isAllServersBusy(int[] serverTime) {
//
//        for (int i = 0; i < serverTime.length; i++) {
//            if (serverTime[i] != 1) {
//                return false;
//            }
//        }
//        return true;
//
//    }

}
