package co.edu.javeriana.pica.jeemp.resources.catalogue;

import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CatalogueService {

    @PersistenceContext(name = "catalogue-pu")
    private EntityManager entityManager;

    public List<Catalogue> fetchAll() {
        return entityManager
                .createNamedQuery("Catalogue.findAll", Catalogue.class)
                .getResultList();
    }

    public Catalogue fetchById(long id) {
        return entityManager
                .createNamedQuery("Catalogue.findById", Catalogue.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst()
                .orElse(new Catalogue());
    }
}
