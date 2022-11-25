public class VideoPlayerMain {

    public static void main(String[] args) {
        Device device = new TV();
        Resolution resolution = new Res1080p();

        VideoPlayer videoPlayer = new TVVideoPlayer(device, resolution);
        videoPlayer.display();

    }
}
