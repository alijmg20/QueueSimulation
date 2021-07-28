package Class.Simulation;

import Class.Datas.DataEntry;
import Class.Datas.DataOut;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Simulation {
/*
    private DataEntry data;

    
    
    // CAMBIAR TODO A ENTERO
    
    
    
    private int[] statusServers;
    private int waitingLength;
    private double timeModeling;
    private double arrivalTime;
    private double[] DepartureTime;
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
        this.DepartureTime = new double[data.getQuantityServers()];
        for (int i = 0; i < data.getQuantityServers(); i++) {
            this.DepartureTime[i] = Integer.MAX_VALUE;
        }
        this.eventNumber = 0;
        this.arrivalNumber = 0;

    }

    public DataOut process() {

        DataOut dataOut = new DataOut();
        String eventName = "condicion inicial";
        int number;
        DefaultTableModel eventModelTable = new DefaultTableModel(null, this.getTitles());

        eventModelTable.addRow(this.addRow(eventNumber, eventName, arrivalNumber, timeModeling,
                statusServers, this.waitingLength, arrivalTime, DepartureTime));
            
        do {

            for (int i = 0; i < this.data.getQuantityServers(); i++) {
                if (this.arrivalTime < this.DepartureTime[i]) {

                    //Arrival process
                    eventName = "Llegada del cliente";
                    this.arrivalNumber++;
                    this.timeModeling = this.arrivalTime;

                    for (int j = 0; j < this.statusServers.length; j++) {

                        if (this.statusServers[j] == 0) {

                            this.statusServers[j] = 1;
                            //double TS = Math.random() * RANDOMNUMBER; //this.getRandomTSArrive();
                            double TS = this.getRandomTSArrive();
                            this.DepartureTime[j] = this.timeModeling + TS;
                            break;

                        } else if (this.isAllServersBusy(this.statusServers)) {
                            this.waitingLength++;
                            break;
                        }
                    }
                    double TE = Math.random() * RANDOMNUMBER;
                    this.arrivalTime = this.timeModeling + TE;
                    number = this.arrivalNumber;
                } else {

                    //departure process
                    eventName = "Salida del cliente";
                    this.departureNumber++;
                    number = this.departureNumber;
                    this.timeModeling = this.DepartureTime[i];

                    if (this.waitingLength > 0) {

                        this.waitingLength--;
//                        double TS = Math.random() * RANDOMNUMBER;//this.getRandomTSService();
                        double TS = this.getRandomTSService();
                        this.DepartureTime[i] = this.timeModeling + TS;
                        eventNumber++;
                        eventModelTable.addRow(this.addRow(eventNumber, eventName, number, timeModeling,
                                statusServers, this.waitingLength, arrivalTime, DepartureTime));
                        break;
                    } else {

                        this.statusServers[i] = 0;
                        this.DepartureTime[i] = Integer.MAX_VALUE;
                        eventNumber++;
                        eventModelTable.addRow(this.addRow(eventNumber, eventName, number, timeModeling,
                                statusServers, this.waitingLength, arrivalTime, DepartureTime));
                        break;
                    }

                }
                eventNumber++;
                eventModelTable.addRow(this.addRow(eventNumber, eventName, number, timeModeling,
                        statusServers, this.waitingLength, arrivalTime, DepartureTime));
            }

        } while (timeModeling < data.getTimeSimulation());
        dataOut.setEventTable(eventModelTable);
        return dataOut;
    }

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

    private Object[] addRow(int eventNumber, String eventName, int number,
            double timeModeling, int[] statusServers, int waitingLenght, double arrivalTime, double[] departureTime) {

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
    
    //PASAR TABLA A UNO
    private double getRandomTSArrive() {
        double timeRandom = Math.random() * RANDOMNUMBER;
        double TS = 0;
        double acum = 0;
        double acum2 = (Double.parseDouble(this.data.getArrivedCustomers().getValueAt(0, 1).toString()) * 100);
        for (int k = 0; k < this.data.getArrivedCustomers().getRowCount(); k++) {

            if (timeRandom > acum
                    && timeRandom < acum2) {
                TS = Double.parseDouble(this.data.getArrivedCustomers().getValueAt(k, 0).toString());
                break;
            }

            acum += Double.parseDouble(this.data.getArrivedCustomers().getValueAt(k, 1).toString()) * 100;
            acum2 += Double.parseDouble(this.data.getArrivedCustomers().getValueAt(k + 1, 1).toString()) * 100;
        }
        return TS;
    }

    private double getRandomTSService() {
        double timeRandom = Math.random() * RANDOMNUMBER;
        double TS = 0;
        double acum = 0;
        double acum2 = (Double.parseDouble(this.data.getServiceTime().getValueAt(0, 1).toString()) * 100);
        for (int k = 0; k < this.data.getArrivedCustomers().getRowCount(); k++) {
            if (timeRandom > acum
                    && timeRandom < acum2) {
                TS = Double.parseDouble(this.data.getServiceTime().getValueAt(k, 0).toString());
                break;
            }
            acum += Double.parseDouble(this.data.getServiceTime().getValueAt(k, 1).toString()) * 100;
            acum2 += Double.parseDouble(this.data.getServiceTime().getValueAt(k + 1, 1).toString()) * 100;
        }
        return TS;
    }

    private boolean isAllServersBusy(int[] serverTime) {

        for (int i = 0; i < serverTime.length; i++) {
            if (serverTime[i] != 1) {
                return false;
            }
        }
        return true;

    }
*/
}
