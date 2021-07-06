
package Class.Simulation;
import Class.Datas.DataEntry;
import Class.Datas.DataOut;

public class Simulation {

    DataEntry data;
    int[] statusServers;
    int waitingLength;
    double timeModeling;
    int arrivalTime;
    int DepartureTime;
    public Simulation(DataEntry data) {
        this.data = data;
        for(int i = 0; i < data.getQuantityServers();i++)
            this.statusServers[i] = 0;
        this.timeModeling = 0;
        this.arrivalTime = 0;
        this.DepartureTime = Integer.MAX_VALUE;
        
    }
   
    public DataOut process(){
        DataOut dataOut = null;
        
        do{
            
            
            
            
        }while(timeModeling < data.getTimeSimulation());
        
        
        return dataOut;
    }
}
