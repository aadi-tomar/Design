public class MainClass {

    public static void main(String[] args) {


        ChainCreator chainCreator = new ChainCreator();
        Managers managers = chainCreator.createChain();
        managers.approveSalary(7000);
        managers.approveSalary( 15000);

        managers.approveSalary( 45000);

        managers.approveSalary( 65000);

    }
}
