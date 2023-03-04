package customer.outbound.entity.jpa;

import customer.domain.customer.Customer;
import customer.domain.customer.repository.CustomerCreateRepository;
import customer.outbound.mapper.CustomerDomainToEntityMapper;
import customer.outbound.entity.customer.CustomerEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@ApplicationScoped
public class CustomerCreateJpaRepository implements CustomerCreateRepository {

    private final EntityManager entityManager;
    private final CustomerDomainToEntityMapper customerDomainToEntityMapper;

    private final Logger log = Logger.getLogger(CustomerCreateJpaRepository.class.getName());

    @Inject
    public CustomerCreateJpaRepository(EntityManager entityManager, CustomerDomainToEntityMapper customerDomainToEntityMapper) {
        this.entityManager = entityManager;
        this.customerDomainToEntityMapper = customerDomainToEntityMapper;
    }

    public CompletionStage<Void> create(Customer customer) {
        return supplyAsync(() -> {
            log.info("create customer: %s".formatted(customer));
            async(customer);
            return null;
        });
    }


    @Transactional
    public void async(Customer customer) {
        CustomerEntity entity = customerDomainToEntityMapper.apply(customer);
        entityManager.persist(entity);
    }

}
