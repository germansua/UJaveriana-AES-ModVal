package co.edu.javeriana.aes.modval.control;

import co.edu.javeriana.aes.modval.entities.Factura;
import com.mongodb.client.FindIterable;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

public class FacturaControl {

    private static final MongoContext mongoContext = MongoContext.getContext();

    public Factura findByReferencia(String referencia) {
        BsonDocument filter = new BsonDocument();
        filter.append("referenciaPago", new BsonString(referencia));
        FindIterable<Document> documents = mongoContext.getFacturacion().find().limit(1);
        Document document = documents.first();

        if (document == null) {
            return new Factura("Nothing Here", 1231.23, Factura.FacturaEstados.SIN_PAGAR);
        }

        return new Factura(
                document.getString("referenciaPago"),
                document.getDouble("valorReferencia"),
                Factura.FacturaEstados.valueOf(document.getString("estadoReferencia")));
    }
}
