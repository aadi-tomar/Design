public class DefaultMediaPlayer implements MediaPlayer{

    @Override
    public void play(String fileToPlay, String formatToPlay) {

        System.out.println("Playing " + fileToPlay + "." + formatToPlay);

    }
}
