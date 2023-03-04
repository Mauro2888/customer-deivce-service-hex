package customer.domain.customer.create.mapper;

import customer.domain.common.DeviceStatus;
import customer.vm.common.DeviceStatusViewModel;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Function;

@ApplicationScoped
public class DeviceStatusMapper implements Function<DeviceStatusViewModel, DeviceStatus> {
    @Override
    public DeviceStatus apply(DeviceStatusViewModel deviceStatusViewModel) {
        return DeviceStatus.valueOf(deviceStatusViewModel.name());
    }
}
