package co.edu.javeriana.aes.modval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.security.SecureRandom;

public class AppConfigTest {

    @Test
    public void test() {
        SecureRandom rand = new SecureRandom();
        rand.ints(1, 0, 999999)
                .distinct()
                .forEach(value -> {
                    System.out.println(
                            String.format(
                                    "db.facturacion.insert({\"numeroFactura\": 9876%06d, \"estadoFactura\": \"POR_PAGAR\", \"valorFactura\": %.2f});",
                                    value,
                                    rand.nextDouble() * 100000)
                    );
                });
    }
}