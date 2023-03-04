package customer.outbound.mapper;

import customer.domain.device.Device;
import customer.outbound.entity.device.DeviceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.Set;
import java.util.function.Function;

@ApplicationScoped
public class DevicesEntityToDomainMapper implements Function<Set<DeviceEntity>, Set<Device>> {

    @Override
    public Set<Device> apply(Set<DeviceEntity> deviceEntities) {
        return deviceEntities.stream()
                .map(deviceEntity -> Device.builder()
                        .withId(deviceEntity.getId())
                        .withStatus(deviceEntity.getStatus())
                        .build())
                .collect(java.util.stream.Collectors.toSet());
    }
}
