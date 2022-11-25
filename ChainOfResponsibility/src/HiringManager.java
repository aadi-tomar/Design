public class HiringManager extends Managers{
    public HiringManager(int approvalLimit, String managersName){
        this.approvalLimit = approvalLimit;
        this.managersName = managersName;
    }


    @Override
    public void processSalary(int empSalary) {
        System.out.println( this.managersName + " has approved the salary at level 1 for salary amount "+ empSalary);
    }
}
