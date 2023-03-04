package customer.vm.api.device.find;

import customer.vm.device.find.DeviceViewModel;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

public interface DeviceFindResource {
    CompletionStage<DeviceViewModel>find(UUID id);
}
