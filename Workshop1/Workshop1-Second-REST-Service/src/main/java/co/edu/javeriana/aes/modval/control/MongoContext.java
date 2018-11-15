package co.edu.javeriana.aes.modval.control;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoContext {

    private static final MongoContext context = new MongoContext();
    private MongoClient client;
    private MongoDatabase convenios;
    private MongoCollection<Document> facturacion;

    private MongoContext() {

        // - MONGO_INITDB_ROOT_USERNAME=mongoadmin - MONGO_INITDB_ROOT_PASSWORD=secret
        // MongoCredential credential = MongoCredential.createCredential("mongoadmin", "admin", "secret".toCharArray());
        //ServerAddress serverAddress = new ServerAddress("mongodb", 27017);
        // client = new MongoClient(serverAddress, credential, MongoClientOptions.builder().build());

        client = new MongoClient("mongodb", 27017);
        convenios = client.getDatabase("convenios");
        facturacion = convenios.getCollection("facturacion");
    }

    public static MongoContext getContext() {
        return context;
    }

    public MongoCollection<Document> getFacturacion() {
        return facturacion;
    }
}
