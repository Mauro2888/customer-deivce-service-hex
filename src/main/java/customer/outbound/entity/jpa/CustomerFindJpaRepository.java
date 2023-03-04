package customer.outbound.entity.jpa;

import customer.domain.customer.Customer;
import customer.domain.customer.repository.CustomerFindRepository;
import customer.outbound.entity.customer.CustomerEntity;
import customer.outbound.mapper.CustomerEntityToDomainMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.concurrent.CompletionStage;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@ApplicationScoped
public class CustomerFindJpaRepository implements CustomerFindRepository {

    private final Logger log = Logger.getLogger(CustomerFindJpaRepository.class.getName());

    private final EntityManager entityManager;

    private final CustomerEntityToDomainMapper customerEntityToDomainMapper;

    @Inject
    public CustomerFindJpaRepository(EntityManager entityManager, CustomerEntityToDomainMapper customerEntityToDomainMapper) {
        this.entityManager = entityManager;
        this.customerEntityToDomainMapper = customerEntityToDomainMapper;
    }

    @Transactional
    public Customer findSync(String codiceFiscale) {
        log.info("find customer: %s".formatted(codiceFiscale));
        var customer = entityManager
                .createNamedQuery(CustomerEntity.FIND_BY_CODICE_FISCALE, CustomerEntity.class)
                .setParameter("codiceFiscale", codiceFiscale)
                .getSingleResult();
        return customerEntityToDomainMapper.apply(customer);
    }

    @Override
    public CompletionStage<Customer> find(String codiceFiscale) {
        var promise = supplyAsync(() -> findSync(codiceFiscale));
        promise.exceptionally(exception -> {
            log.log(Level.SEVERE, "Failed to find customer", exception);
            return null;
        });
        return promise;
    }
}
