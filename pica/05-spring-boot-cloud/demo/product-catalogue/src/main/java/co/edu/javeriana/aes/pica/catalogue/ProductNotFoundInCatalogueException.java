package co.edu.javeriana.aes.pica.catalogue;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundInCatalogueException extends Exception {

    public ProductNotFoundInCatalogueException(long id) {
        super(String.format("Product with id; %d not found in catalogue", id));
    }
}
