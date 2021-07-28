
package Class.Simulation;

public class Server {
    
    private int statusServers;
    private double DepartureTime;

    public Server(int statusServers, double DepartureTime) {
        this.statusServers = statusServers;
        this.DepartureTime = DepartureTime;
    }
    
    
    

    public int getStatusServers() {
        return statusServers;
    }
    
    public double getDepartureTime() {
        return DepartureTime;
    }

    public void setStatusServers(int statusServers) {
        this.statusServers = statusServers;
    }

    

    public void setDepartureTime(double DepartureTime) {
        this.DepartureTime = DepartureTime;
    }
    
    
    
}
