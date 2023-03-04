package customer.inbound.device.find.mapper;

import customer.domain.device.Device;
import customer.vm.device.find.DeviceViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Function;

@ApplicationScoped
public class DeviceViewModelMapper implements Function<Device, DeviceViewModel> {

    private final DeviceStatusViewModelMapper statusMapper;

    @Inject
    public DeviceViewModelMapper(DeviceStatusViewModelMapper statusMapper) {
        this.statusMapper = statusMapper;
    }

    @Override
    public DeviceViewModel apply(Device device) {
        return DeviceViewModel.builder()
                .withId(device.getId())
                .withStatus(statusMapper.apply(device.getStatus()))
                .build();
    }
}
