public class IngestionService {

    private IngestionFactory ingestionFactory;

    public IngestionService(IngestionFactory ingestionFactory) {
        this.ingestionFactory = ingestionFactory;
    }

    public void ingestDataToDatabase(String source){

        IngestToDatabase ingestToDatabase = ingestionFactory.getInstanceOfSource(source);
        ingestToDatabase.ingestData();

    }


}
