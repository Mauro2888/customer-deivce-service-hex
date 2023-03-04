package customer.vm.api.device.update;

import customer.vm.common.DeviceStatusUpdateViewModel;
import customer.vm.common.DeviceStatusViewModel;

import java.util.concurrent.CompletionStage;

public interface UpdateDeviceStatusResource {
    CompletionStage<Void> update(String deviceId, DeviceStatusUpdateViewModel status);
}
