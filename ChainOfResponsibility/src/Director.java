public class Director extends Managers{

    public Director(int approvalLimit, String managerName){
        this.approvalLimit = approvalLimit;
        this.managersName = managerName;
    }
    @Override
    public void processSalary(int empSalary) {
        System.out.println(this.managersName + " has approved at level 3 the salary of rs. " + empSalary);
    }
}
