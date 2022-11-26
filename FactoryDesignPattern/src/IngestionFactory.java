public class IngestionFactory {


    public IngestToDatabase getInstanceOfSource(String source){
        IngestToDatabase ingestToDatabase = null;

        if( source.equals("API"))
            ingestToDatabase = new SourceDataFromAPI();
        else if( source.equals("File"))
            ingestToDatabase = new SourceDataFromFile();
        else
            ingestToDatabase = new SourceDataFromDataLake();
        return ingestToDatabase;
    }
}
