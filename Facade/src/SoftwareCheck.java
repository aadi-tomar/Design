public class SoftwareCheck {

    private Drivers drivers;
    private OSCheck osCheck;

    public SoftwareCheck() {
        this.drivers = new Drivers();
        this.osCheck = new OSCheck();
    }

    public boolean checkSoftwaresOnBoot(){
        return drivers.checkDrivers() && osCheck.checkOSonBoot();
    }
}
