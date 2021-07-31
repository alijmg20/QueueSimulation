package Class.Simulation;

import Class.Datas.ClientsData;
import java.util.ArrayList;

public class Cliente {

    ClientsData data1 = new ClientsData();
    ArrayList<ClientsData> DataC = new ArrayList<>();

    //Columna 1: Numero del cliente
    //Columna 2: Tiempo de llegada
    //Columna 3: Tiempo de salida
    //Columna 4: Tiempo total en servicio
    //Columna 5: Proceso de llegada o salida
    //Columna 6: Servidor que lo atiende
    public void InputData(int llegada) {

        // lo demas se limpia, y se imcrementa el cliente
        data1.setArrivedTime(llegada);
        data1.setExitTime(0);
        data1.setService(0);
        data1.setTotalServiceTime(0);
        data1.setClient(DataC.size() + 1);

        this.DataC.add(data1);
    }

    public int chaoCliente() {
        int i = 0;

        do {
            i++;
        } while (DataC.get(i).getExitTime() != 0); // se busca el cliente que no tenga una salida

        int j = 0;
        do {
            j++;
        } while (DataC.get(i).getService() == 0);

        DataC.get(j).setService(DataC.get(i).getService());

        return DataC.get(i).getClient();
    }

    //Manda el cliente que generas de chaoCliente
    public void OutputData(int NroCliente, int TiempoSalida) {
        int i = 0;
        do {
            i++;
        } while (NroCliente == DataC.get(i).getClient());

        DataC.get(i).setTotalServiceTime(TiempoSalida - DataC.get(i).getArrivedTime());
        DataC.get(i).setExitTime(TiempoSalida);
    }

}
