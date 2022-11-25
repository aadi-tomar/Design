public class AviPlayer implements AdvanceMediaPlayer {

    @Override
    public void playAdvanceFormat(AdvanceFormat advanceFormat) {
        System.out.println(" Playing advance music file " + advanceFormat.getFileToPlay() + "."
                + advanceFormat.getFormatToPlay() + " in resolution " + advanceFormat.getResolution());
    }
}
