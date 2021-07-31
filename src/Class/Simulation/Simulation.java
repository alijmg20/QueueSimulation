package Class.Simulation;

import Class.Datas.ClientsData;
import Class.Datas.DataEntry;
import Class.Datas.DataOut;
import java.util.ArrayList;
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
            this.DepartureTime[i] = Integer.MAX_VALUE;
        }
        this.eventNumber = 0;
        this.arrivalNumber = 0;

    }

    public DataOut process() {

        Cliente client = new Cliente();
        
        DataOut dataOut = new DataOut();
        String eventName = "condicion inicial";
        int number;
        DefaultTableModel eventModelTable = new DefaultTableModel(null, this.getTitles());

        eventModelTable.addRow(this.addRow(eventNumber, eventName, arrivalNumber, timeModeling,
                statusServers, this.waitingLength, arrivalTime, DepartureTime));
            
//        do {
//
//            for (int i = 0; i < this.data.getQuantityServers(); i++) {
//                if (this.arrivalTime < this.DepartureTime[i]) {
//                    
//                    //Arrival process
//                    
//                    eventName = "Llegada del cliente";
//                    this.arrivalNumber++;
//                    this.timeModeling = this.arrivalTime;
//
//                    for (int j = 0; j < this.statusServers.length; j++) {
//
//                        if (this.statusServers[j] == 0) {
//
//                            this.statusServers[j] = 1;
//                            //int TS = Math.random() * RANDOMNUMBER; //this.getRandomTSArrive();
//                            int TS = this.getRandomTS(this.data.getArrivedCustomers());
//                            this.DepartureTime[j] = this.timeModeling + TS;
//                            break;
//
//                        } else if () {
//                            this.waitingLength++;
//                            break;
//                        }
//                    }
//                    
//                    Random rand = new Random();
//                    int TE = rand.nextInt() * RANDOMNUMBER;
//                    this.arrivalTime = this.timeModeling + TE;
//                    number = this.arrivalNumber;
//                    
//                } else {
//                    
//                    //departure process
//                    
//                    eventName = "Salida del cliente";
//                    this.departureNumber++;
//                    number = this.departureNumber;
//                    this.timeModeling = this.DepartureTime[i];
//
//                    if (this.waitingLength > 0) {
//
//                        this.waitingLength--;
////                        int TS = Math.random() * RANDOMNUMBER;//this.getRandomTSService();
//                        int TS = this.getRandomTSService();
//                        this.DepartureTime[i] = this.timeModeling + TS;
//                        eventNumber++;
//                        eventModelTable.addRow(this.addRow(eventNumber, eventName, number, timeModeling,
//                                statusServers, this.waitingLength, arrivalTime, DepartureTime));
//                        break;
//                    } else {
//
//                        this.statusServers[i] = 0;
//                        this.DepartureTime[i] = Integer.MAX_VALUE;
//                        eventNumber++;
//                        eventModelTable.addRow(this.addRow(eventNumber, eventName, number, timeModeling,
//                                statusServers, this.waitingLength, arrivalTime, DepartureTime));
//                        break;                        
//                        
//                    }
//
//                }
//                eventNumber++;
//                eventModelTable.addRow(this.addRow(eventNumber, eventName, number, timeModeling,
//                        statusServers, this.waitingLength, arrivalTime, DepartureTime));
//            }
//
//        } while (timeModeling < data.getTimeSimulation());
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
