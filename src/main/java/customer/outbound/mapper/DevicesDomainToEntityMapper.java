package customer.outbound.mapper;

import customer.domain.device.Device;
import customer.outbound.entity.device.DeviceEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class DevicesDomainToEntityMapper implements Function<Set<Device>, Set<DeviceEntity>> {

    private final DeviceDomainToEnityMapper deviceDomainToEnityMapper;

    @Inject
    public DevicesDomainToEntityMapper(DeviceDomainToEnityMapper deviceDomainToEnityMapper) {
        this.deviceDomainToEnityMapper = deviceDomainToEnityMapper;
    }

    @Override
    public Set<DeviceEntity> apply(Set<Device> devices) {
        return devices.stream().map(deviceDomainToEnityMapper).collect(Collectors.toSet());
    }
}
