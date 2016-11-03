package co.edu.javeriana.aes.modaval.pagos.boundary;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService
public class DummyService {

    public int sum(int x, int y) {
        return x + y;
    }
}
