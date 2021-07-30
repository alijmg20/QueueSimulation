
package Class.Datas;

import javax.swing.table.DefaultTableModel;

public class DataEntry  {
    
    private String timeUnit;
    
    private boolean eventTable;
    
    private int timeSimulation;
    
    private int quantityCustomers ;
    
    private int quantityServers;
    
    private DefaultTableModel ArrivedCustomers;
    
    private DefaultTableModel ServiceTime;
    
    private int costTimeCustomer ; //cost time in customer service
    
    private int costTimeWaitCustomer ; // cost of customer waiting
    
    private int busyServercost; // cost server busy  
    
    private int idleServerCost ; // cost any server idle
    
    private int extraTimeServerCost; //Cost of extra time in servers
    
    private int costNormalOperation; //cost normal operation in the system
    
    private int extraOperationCost; // cost extra operation in the system

    public DataEntry() {
        this.timeUnit = "Horas";
        this.eventTable = false;
        this.timeSimulation = 0;
        this.quantityCustomers = 0;
        this.quantityServers = 0;
        this.ArrivedCustomers = new DefaultTableModel();
        this.ServiceTime = new DefaultTableModel();
        this.costTimeCustomer = 0;
        this.costTimeWaitCustomer = 0;
        this.busyServercost = 0;
        this.idleServerCost = 0;
        this.extraTimeServerCost = 0;
        this.costNormalOperation = 0;
        this.extraOperationCost = 0;
    }

    public DataEntry(String timeUnit, boolean eventTable, int timeSimulation, int quantityCustomers, 
            int quantityServers, DefaultTableModel ArrivedCustomers, DefaultTableModel ServiceTime, 
            int costTimeCustomer, int costTimeWaitCustomer, int busyServercost, int idleServerCost, 
            int extraTimeServerCost, int costNormalOperation, int extraOperationCost) {
        
        this.timeUnit = timeUnit;
        this.eventTable = eventTable;
        this.timeSimulation = timeSimulation;
        this.quantityCustomers = quantityCustomers;
        this.quantityServers = quantityServers;
        this.ArrivedCustomers = ArrivedCustomers;
        this.ServiceTime = ServiceTime;
        this.costTimeCustomer = costTimeCustomer;
        this.costTimeWaitCustomer = costTimeWaitCustomer;
        this.busyServercost = busyServercost;
        this.idleServerCost = idleServerCost;
        this.extraTimeServerCost = extraTimeServerCost;
        this.costNormalOperation = costNormalOperation;
        this.extraOperationCost = extraOperationCost;
    }

    public String getTimeUnit() {
        return timeUnit;
    }
    
    public String getEventTable(){
        return this.eventTable ? "si":"no";
    }

    public boolean isEventTable() {
        return eventTable;
    }

    public int getTimeSimulation() {
        return timeSimulation;
    }

    public int getQuantityCustomers() {
        return quantityCustomers;
    }

    public int getQuantityServers() {
        return quantityServers;
    }

    public DefaultTableModel getArrivedCustomers() {
        return ArrivedCustomers;
    }

    public DefaultTableModel getServiceTime() {
        return ServiceTime;
    }

    public int getCostTimeCustomer() {
        return costTimeCustomer;
    }

    public int getCostTimeWaitCustomer() {
        return costTimeWaitCustomer;
    }

    public int getBusyServercost() {
        return busyServercost;
    }

    public int getIdleServerCost() {
        return idleServerCost;
    }

    public int getExtraTimeServerCost() {
        return extraTimeServerCost;
    }

    public int getCostNormalOperation() {
        return costNormalOperation;
    }

    public int getExtraOperationCost() {
        return extraOperationCost;
    }
    
    //Seters

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void setEventTable(boolean eventTable) {
        this.eventTable = eventTable;
    }
    
    public void setEventTable(String eventTable){
        this.eventTable = eventTable.equals("si");
    }

    public void setTimeSimulation(int timeSimulation) {
        this.timeSimulation = timeSimulation;
    }

    public void setQuantityCustomers(int quantityCustomers) {
        this.quantityCustomers = quantityCustomers;
    }

    public void setQuantityServers(int quantityServers) {
        this.quantityServers = quantityServers;
    }

    public void setArrivedCustomers(DefaultTableModel ArrivedCustomers) {
        this.ArrivedCustomers = ArrivedCustomers;
    }

    public void setServiceTime(DefaultTableModel ServiceTime) {
        this.ServiceTime = ServiceTime;
    }

    public void setCostTimeCustomer(int costTimeCustomer) {
        this.costTimeCustomer = costTimeCustomer;
    }

    public void setCostTimeWaitCustomer(int costTimeWaitCustomer) {
        this.costTimeWaitCustomer = costTimeWaitCustomer;
    }

    public void setBusyServercost(int busyServercost) {
        this.busyServercost = busyServercost;
    }

    public void setIdleServerCost(int idleServerCost) {
        this.idleServerCost = idleServerCost;
    }

    public void setExtraTimeServerCost(int extraTimeServerCost) {
        this.extraTimeServerCost = extraTimeServerCost;
    }

    public void setCostNormalOperation(int costNormalOperation) {
        this.costNormalOperation = costNormalOperation;
    }

    public void setExtraOperationCost(int extraOperationCost) {
        this.extraOperationCost = extraOperationCost;
    }
    
    
    
    
    
    

 
    
    
}
