public class MediaPlayerImpl implements MediaPlayer{

    MediaPlayerAdapter mediaPlayerAdapter;
    MediaPlayer mediaPlayer;

    @Override
    public void play(String fileToPlay, String FormatToPlay) {
        if(FormatToPlay.equals("mp3")){
            mediaPlayer = new DefaultMediaPlayer();
            mediaPlayer.play(fileToPlay, FormatToPlay);
        }
        else{
            AdvanceFormat advanceFormat = new AdvanceFormat();
            advanceFormat.setResolution("1080p");
            mediaPlayerAdapter = new MediaPlayerAdapter(advanceFormat);
            mediaPlayerAdapter.play(fileToPlay, FormatToPlay);
        }
    }
}
