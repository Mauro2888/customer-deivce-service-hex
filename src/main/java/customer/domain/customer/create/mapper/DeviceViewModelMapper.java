package customer.domain.customer.create.mapper;

import customer.domain.device.Device;
import customer.vm.device.create.DeviceCreateViewModel;
import customer.vm.device.find.DeviceViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

@ApplicationScoped
public class DeviceViewModelMapper implements Function<Set<DeviceCreateViewModel>, Set<Device>> {

    private final DeviceMapper deviceMapper;

    @Inject
    public DeviceViewModelMapper(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    @Override
    public Set<Device> apply(Set<DeviceCreateViewModel> deviceViewModels) {
        return deviceViewModels.stream()
                .map(deviceMapper)
                .collect(toSet());
    }
}
