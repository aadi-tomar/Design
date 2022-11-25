public abstract class VideoPlayer {

    Device currentDevice;
    Resolution currentResolution;

    void getDevice(){
        currentDevice.device();
    }
    void getResolution(){
        currentResolution.resolution();
    }

    abstract void display();
}
