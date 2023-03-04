package customer.domain.customer.create.mapper;

import customer.domain.device.Device;
import customer.vm.device.create.DeviceCreateViewModel;
import customer.vm.device.find.DeviceViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Function;

@ApplicationScoped
public class DeviceMapper implements Function<DeviceCreateViewModel, Device> {
    private final DeviceStatusMapper deviceStatusMapper;

    @Inject
    public DeviceMapper(DeviceStatusMapper deviceStatusMapper) {
        this.deviceStatusMapper = deviceStatusMapper;
    }

    @Override
    public Device apply(DeviceCreateViewModel deviceViewModel) {
        return Device.builder()
                .withStatus(deviceStatusMapper.apply(deviceViewModel.status()))
                .build();
    }
}
