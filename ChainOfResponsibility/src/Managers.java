public abstract class Managers {

    private Managers manager;
     int approvalLimit;
     String managersName;

    public void setManager(Managers manager){
        this.manager = manager;
    }

    public void approveSalary( int empSalary){
        if( this.approvalLimit > empSalary){
            processSalary( empSalary);
        }
        else if( manager !=null){
            manager.approveSalary(empSalary);
        }
        else{
            System.out.println(" Sorry, We cant make the offer due to high salary demand");
        }


    }
    public abstract void processSalary(int empSalary);

}
