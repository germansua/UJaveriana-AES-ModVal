package co.edu.javeriana.aes.pica.catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {

    @Autowired
    CatalogueService catalogueService;

    @GetMapping
    public List<Catalogue> getAll() {
        return catalogueService.fetchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Catalogue> getById(@PathVariable long id, @RequestParam String currency)
            throws ProductNotFoundInCatalogueException {
        return ResponseEntity.ok(catalogueService.fetchByIdPriceByCurrency(id, currency));
    }
}
