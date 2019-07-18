package co.edu.javeriana.aes.modval.pagos.control;

import co.edu.javeriana.aes.modval.pagos.entities.Estados;
import co.edu.javeriana.aes.modval.pagos.entities.EstadosValidos;
import co.edu.javeriana.aes.modval.pagos.entities.Facturas;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@LocalBean
@Stateless
public class FacturasControl {

    private static final Logger LOGGER = Logger.getLogger(FacturasControl.class.getName());

    @PersistenceContext(unitName = "domiciliacion")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Facturas getFacturaByReferencia(@NotNull String referencia) {
        TypedQuery<Facturas> namedQuery = entityManager.createNamedQuery("Facturas.findByReferencia", Facturas.class);
        namedQuery.setParameter("referencia", referencia);

        Facturas result = null;
        try {
            result = namedQuery.getSingleResult();
        } catch (NoResultException ex) {
            LOGGER.info(String.format("No reference found: %s", referencia));
        }

        return result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean pagarFactura(@NotNull String referencia) {
        Facturas factura = getFacturaByReferencia(referencia);
       
        boolean validation = factura.getEstado().getEstado().equals(EstadosValidos.PAGADA);
        if (!validation) {
            factura.setEstado(new Estados(EstadosValidos.PAGADA));
        }
        
        return !validation;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean compensarFactura(@NotNull String referencia) {
        Facturas factura = getFacturaByReferencia(referencia);
        
        EstadosValidos estadoActual = factura.getEstado().getEstado();
        
        boolean validation = estadoActual.equals(EstadosValidos.PAGADA);
        if (validation) {
            factura.setEstado(new Estados(EstadosValidos.PENDIENTE));
        }
        
        return validation;
    }
}
