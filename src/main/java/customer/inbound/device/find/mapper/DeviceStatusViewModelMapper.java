package customer.inbound.device.find.mapper;

import customer.domain.common.DeviceStatus;
import customer.vm.common.DeviceStatusViewModel;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Function;

@ApplicationScoped
public class DeviceStatusViewModelMapper implements Function<DeviceStatus, DeviceStatusViewModel> {

    @Override
    public DeviceStatusViewModel apply(DeviceStatus deviceStatus) {
        return DeviceStatusViewModel.valueOf(deviceStatus.name());
    }
}
