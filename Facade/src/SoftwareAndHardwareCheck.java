public class SoftwareAndHardwareCheck {

    private SoftwareCheck softwareCheck;
    private HardwareCheck hardwareCheck;

    public SoftwareAndHardwareCheck(){
        this.softwareCheck = new SoftwareCheck();
        this.hardwareCheck = new HardwareCheck();
    }

    public boolean check(){
        System.out.println("Checking hardware and software before booting up the system ");
        return softwareCheck.checkSoftwaresOnBoot() && hardwareCheck.checkHardwareOnBoot();
    }
}
