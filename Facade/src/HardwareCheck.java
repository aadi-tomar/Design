public class HardwareCheck {

    private MotherBoard motherBoard;
    private RAM ram;

    public HardwareCheck() {
        this.motherBoard = new MotherBoard();
        this.ram = new RAM();
    }

    public boolean checkHardwareOnBoot(){
        return motherBoard.checkMotherBoard() && ram.checkRAM();
    }
}
