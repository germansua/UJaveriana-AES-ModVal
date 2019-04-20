package co.edu.javeriana.aes.modval.timestamp.control;

import co.edu.javeriana.aes.modval.timestamp.entity.Timestamp;

/**
 * This class represents the actual service that generates the timestamp value
 */
public class TimestampService {

    public Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
