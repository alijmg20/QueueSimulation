package Class.Datas;

public class ServersData {
    //Tiempo de servicio
    //Tiempos en servicio
    
    private int DepartureT;
    private int ServerInUse; // ocupado - desocupado
    private int EventNumb;  // numero de envento
    
    public ServersData() {
        this.DepartureT = 99999;
        this.ServerInUse = 0;
        this.EventNumb = -1;
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

    public int getEventNumb() {
        return EventNumb;
    }

    public void setEventNumb(int NumbClient) {
        this.EventNumb = NumbClient;
    }
}
