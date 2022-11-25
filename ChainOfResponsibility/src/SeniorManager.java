public class SeniorManager extends Managers{

    public SeniorManager(int approvalLimit, String managerName){
        this.approvalLimit = approvalLimit;
        this.managersName = managerName;
    }
    @Override
    public void processSalary(int empSalary) {
        System.out.println(this.managersName + " has approved at level 2 the salary of rs. " + empSalary);
    }
}
