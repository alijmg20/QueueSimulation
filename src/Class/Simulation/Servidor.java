package Class.Simulation;

import Class.Datas.DataEntry;
import Class.Datas.ServersData;


public class Servidor {
    
    DataEntry data2 = new DataEntry();
    //Columna 0 es el primer servidor
    ServersData ServerData[][] = new ServersData[data2.getQuantityCustomers()][data2.getQuantityServers()];
    
    public void insertServerData (int Departure,int InUse,int Server) {
        this.ServerData[ServerData[Server-1].length][Server-1].setDepartureT(Departure);
        this.ServerData[ServerData[Server-1].length][Server-1].setServerInUse(InUse);
    }
    
    
}
