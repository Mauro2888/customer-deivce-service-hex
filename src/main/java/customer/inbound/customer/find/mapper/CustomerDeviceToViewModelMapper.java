package customer.inbound.customer.find.mapper;

import customer.domain.device.Device;
import customer.inbound.device.find.mapper.DeviceStatusViewModelMapper;
import customer.vm.device.find.DeviceViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

@ApplicationScoped
public class CustomerDeviceToViewModelMapper implements Function<Set<Device>, Set<DeviceViewModel>> {

    private final DeviceStatusViewModelMapper statusMapper;

    @Inject
    public CustomerDeviceToViewModelMapper(DeviceStatusViewModelMapper statusMapper) {
        this.statusMapper = statusMapper;
    }

    @Override
    public Set<DeviceViewModel> apply(Set<Device> devices) {
        return devices.stream()
                .map(device -> DeviceViewModel.builder()
                        .withId(device.getId())
                        .withStatus(statusMapper.apply(device.getStatus()))
                        .build())
                .collect(toSet());
    }
}
