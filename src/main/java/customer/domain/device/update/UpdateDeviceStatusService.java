package customer.domain.device.update;

import customer.domain.common.DeviceStatus;

import java.util.concurrent.CompletionStage;

public interface UpdateDeviceStatusService {
    CompletionStage<Void>update(String deviceId, DeviceStatus status);
}
