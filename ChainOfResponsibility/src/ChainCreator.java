public class ChainCreator {
    public Managers createChain() {
        HiringManager hiringManager = new HiringManager(10000, " Nitin");
        SeniorManager seniorManager = new SeniorManager(30000, " Ram");
        Director director = new Director(50000, " Aaditya");

        hiringManager.setManager(seniorManager);
        seniorManager.setManager(director);
        return hiringManager;

    }

}
