package customer.outbound.mapper;

import customer.domain.device.Device;
import customer.outbound.entity.device.DeviceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Function;

@ApplicationScoped
public class DeviceDomainToEnityMapper implements Function<Device, DeviceEntity>{
    @Override
    public DeviceEntity apply(Device device) {
        return DeviceEntity.Builder()
                .withId(device.getId())
                .withStatus(device.getStatus())
                .build();
    }
}
