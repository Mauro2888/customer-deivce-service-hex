package customer.outbound.entity.jpa;

import customer.domain.common.DeviceStatus;
import customer.domain.customer.CustomerAddress;
import customer.domain.customer.repository.CustomerUpdateAddressRepository;
import customer.outbound.entity.customer.CustomerEntity;
import customer.outbound.entity.device.DeviceEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.UUID;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@ApplicationScoped
public class CustomerAddressUpdateJpaRepository implements CustomerUpdateAddressRepository {

    private final EntityManager entityManager;
    private final Logger log = Logger.getLogger(CustomerAddressUpdateJpaRepository.class.getName());
    public CustomerAddressUpdateJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CompletionStage<Void> update(String codicefiscale, CustomerAddress customerAddress) {
        return supplyAsync(() -> {
            log.info("update customer : %s with address : %s".formatted(codicefiscale,customerAddress.indirizzo()));
            updateAsync(codicefiscale, customerAddress);
            return null;
        });
    }

    @Transactional
    public void updateAsync(String codiceFiscale, CustomerAddress customerAddress) {
        entityManager.createNamedQuery(CustomerEntity.UPDATE_ADDRESS)
                .setParameter("codiceFiscale", codiceFiscale)
                .setParameter("indirizzo", customerAddress.indirizzo())
                .executeUpdate();
    }
}
