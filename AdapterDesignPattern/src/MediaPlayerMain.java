public class MediaPlayerMain {

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayerImpl();

        mediaPlayer.play("Ishqiya", "mp3");
        mediaPlayer.play("mySongInNewFormat", "avi");
    }
}
