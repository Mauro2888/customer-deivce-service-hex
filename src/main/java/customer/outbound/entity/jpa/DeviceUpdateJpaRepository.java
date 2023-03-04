package customer.outbound.entity.jpa;

import customer.domain.common.DeviceStatus;
import customer.domain.device.repository.DeviceUpdateRepository;
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
public class DeviceUpdateJpaRepository implements DeviceUpdateRepository {

    private final EntityManager entityManager;

    private final Logger log = Logger.getLogger(DeviceUpdateJpaRepository.class.getName());

    @Inject
    public DeviceUpdateJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Transactional
    public void async(String id, DeviceStatus status) {
        entityManager.createNamedQuery(DeviceEntity.UPDATE_STATUS)
                .setParameter("id", UUID.fromString(id))
                .setParameter("status", status)
                .executeUpdate();
    }

    @Override
    public CompletionStage<Void> updateStatus(String deviceId, DeviceStatus status) {
        return supplyAsync(() -> {
            log.info("update device status: %s".formatted(status.name()));
            async(deviceId, status);
            return null;
        });
    }
}
