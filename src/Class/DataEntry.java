
package Class;

import javax.swing.table.DefaultTableModel;

public class DataEntry  {
    
    private String timeUnit;
    
    private boolean eventTable;
    
    private double timeSimulation;
    
    private int quantityCustomers ;
    
    private int quantityServers;
    
    private DefaultTableModel ArrivedCustomers;
    
    private DefaultTableModel ServiceTime;
    
    private double costServiceCustomer ; //cost time in customer service
    
    private double costWaitingCustomer ; // cost of customer waiting
    
    private double costServers; // cost any server in the system
    
    private double costBusyServer ; //cost server busy 
    
    private double extraTimeServerCost; //Cost of extra time in servers
    
    private double costNormalOperation; //cost normal operation in the system
    
    private double extraOperationCost; // cost extra operation in the system

    public DataEntry() {
        this.timeUnit = "Horas";
        this.eventTable = false;
        this.timeSimulation = 0;
        this.quantityCustomers = 0;
        this.quantityServers = 0;
        this.ArrivedCustomers = null;
        this.ServiceTime = null;
        this.costServiceCustomer = 0;
        this.costWaitingCustomer = 0;
        this.costServers = 0;
        this.costBusyServer = 0;
        this.extraTimeServerCost = 0;
        this.costNormalOperation = 0;
        this.extraOperationCost = 0;
    }
    
    

    public DataEntry(String timeUnit, boolean eventTable, double timeSimulation, int quantityCustomers, int quantityServers, DefaultTableModel ArrivedCustomers, DefaultTableModel ServiceTime, double costServiceCustomer, double costWaitingCustomer, double costServers, double costBusyServer, double extraTimeServerCost, double costNormalOperation, double extraOperationCost) {
        this.timeUnit = timeUnit;
        this.eventTable = eventTable;
        this.timeSimulation = timeSimulation;
        this.quantityCustomers = quantityCustomers;
        this.quantityServers = quantityServers;
        this.ArrivedCustomers = ArrivedCustomers;
        this.ServiceTime = ServiceTime;
        this.costServiceCustomer = costServiceCustomer;
        this.costWaitingCustomer = costWaitingCustomer;
        this.costServers = costServers;
        this.costBusyServer = costBusyServer;
        this.extraTimeServerCost = extraTimeServerCost;
        this.costNormalOperation = costNormalOperation;
        this.extraOperationCost = extraOperationCost;
    }
    
    
    
    
    
    
    
}
