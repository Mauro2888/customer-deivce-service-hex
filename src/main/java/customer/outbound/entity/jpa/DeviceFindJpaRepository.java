package customer.outbound.entity.jpa;

import customer.domain.device.Device;
import customer.domain.device.repository.DeviceFindRepository;
import customer.outbound.entity.common.exception.RepositoryException;
import customer.outbound.mapper.DeviceEntityToDomainMapper;
import customer.outbound.entity.device.DeviceEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.UUID;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@ApplicationScoped
public class DeviceFindJpaRepository implements DeviceFindRepository {

    private final EntityManager entityManager;

    private final DeviceEntityToDomainMapper deviceEntityToDomainMapper;

    private final Logger log = Logger.getLogger(DeviceFindJpaRepository.class.getName());

    @Inject
    public DeviceFindJpaRepository(EntityManager entityManager, DeviceEntityToDomainMapper deviceEntityToDomainMapper) {
        this.entityManager = entityManager;
        this.deviceEntityToDomainMapper = deviceEntityToDomainMapper;
    }


    @Override
    public CompletionStage<Device> find(UUID id) {
        var result = supplyAsync(() -> findSync(id));
        result.thenAccept(device -> log.info("Found device with id %s".formatted(id)));
        result.exceptionally(exception -> {
            log.severe("Failed to find device with id %s".formatted(id));
            return null;
        });
        return result;
    }

    @Transactional
    public Device findSync(UUID id) {
        try {
            var result = entityManager.createNamedQuery(DeviceEntity.FIND_BY_ID, DeviceEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return deviceEntityToDomainMapper.apply(result);
        } catch (Exception e) {
            throw new RepositoryException(id.toString());
        }
    }
}
