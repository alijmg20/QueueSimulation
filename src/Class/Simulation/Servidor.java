package Class.Simulation;

import Class.Datas.DataEntry;
import Class.Datas.ServersData;

public class Servidor {

    DataEntry data2 = new DataEntry();
    ServersData ServerData[][];
    int[] timeinIdle;
    int[] timeTotals;
    //Columna 0 es el primer servidor

    public Servidor(DataEntry data2) {
        this.data2 = data2;
        this.ServerData = new ServersData[data2.getQuantityCustomers()][data2.getQuantityServers()];
        for (int i = 0; i < ServerData.length; i++) {
            for (int j = 0; j < ServerData.length; j++) {
                this.ServerData[i][j] = new ServersData();
            }
        }
        this.timeinIdle = new int[data2.getQuantityServers()];
        this.timeTotals = new int[data2.getQuantityServers()];
    }

    public void insertServerData(int Departure, int InUse, int Server) {
        this.ServerData[ServerData[Server - 1].length][Server - 1].setDepartureT(Departure);
        this.ServerData[ServerData[Server - 1].length][Server - 1].setServerInUse(InUse);
        this.timeTotals[Server - 1] += Departure;
    }

    public void IdleTime() {

        for (int j = 0; j < data2.getQuantityServers(); j++) { //Servers
            for (int i = 0, aux = 0; i < data2.getQuantityCustomers(); i++) {//Tiempos
                if (ServerData[i][j].getServerInUse() == 0) {//No esta en uso
                    aux = ServerData[i - 1][j].getDepartureT();
                    while (ServerData[i][j].getServerInUse() == 0 && i < data2.getQuantityCustomers()) {//Mientas no este en uso y no se acaben los clientes
                        i++;
                    }
                    if (i < data2.getQuantityCustomers()) {
                        aux = ServerData[i][j].getDepartureT() - aux;
                    } else {
                        aux = data2.getTimeSimulation() - aux;
                    }
                    this.timeinIdle[j] += aux;
                }
            }
        }
    }
}
