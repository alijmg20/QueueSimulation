package Class.Datas;

public class ClientsData {
    
    private int Client;
    private int ArrivedTime;
    private int ExitTime;
    private int TotalServiceTime;
    private int ProcessType; //1: Llegada ; 2: Salida
    private int Service;
    
    
    public ClientsData() {
        this.Client = 0;
        this.ArrivedTime = 0;
        this.ExitTime = 0;
        this.TotalServiceTime = 0;
        this.Service = 0;
    }

    public int getExitTime() {
        return ExitTime;
    }

    public void setExitTime(int ExitTime) {
        this.ExitTime = ExitTime;
    }

    public int getClient() {
        return Client;
    }

    public void setClient(int Client) {
        this.Client = Client;
    }

    public int getArrivedTime() {
        return ArrivedTime;
    }

    public void setArrivedTime(int ArrivedTime) {
        this.ArrivedTime = ArrivedTime;
    }

    public int getTotalServiceTime() {
        return TotalServiceTime;
    }

    public void setTotalServiceTime(int TotalServiceTime) {
        this.TotalServiceTime = TotalServiceTime;
    }

    public int getService() {
        return Service;
    }

    public void setService(int Service) {
        this.Service = Service;
    }
    
}


