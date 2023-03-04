package customer.outbound.mapper;

import customer.domain.device.Device;
import customer.outbound.entity.device.DeviceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Function;

@ApplicationScoped
public class CustomerDeviceEntityToDomainMapper implements Function<DeviceEntity, Device> {
    @Override
    public Device apply(DeviceEntity deviceEntity) {
        return Device.builder()
                .withId(deviceEntity.getId())
                .withStatus(deviceEntity.getStatus())
                .build();
    }
}
