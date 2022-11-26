public class ApplicationMain {

    public static void main(String[] args) {
        IngestionService ingestionService = new IngestionService( new IngestionFactory());
        ingestionService.ingestDataToDatabase("File");
    }

}
