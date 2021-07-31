package Class.Datas;

public class ServersData {
    //Tiempo de servicio
    //Tiempos en servicio
    
    private int DepartureT;
    private int ServerInUse; // ocupado - desocupado
    private int ClientTime;  //
    public ServersData() {
        this.DepartureT = 99999;
        this.ServerInUse = 0;
    }

    public int getDepartureT() {
        return DepartureT;
    }

    public void setDepartureT(int DepartureT) {
        this.DepartureT = DepartureT;
    }

    public int getServerInUse() {
        return ServerInUse;
    }

    public void setServerInUse(int ServerInUse) {
        this.ServerInUse = ServerInUse;
    }
    
    
}
