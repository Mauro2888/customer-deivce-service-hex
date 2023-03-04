package customer.domain.device.repository;

import customer.domain.common.DeviceStatus;

import java.util.concurrent.CompletionStage;

public interface DeviceUpdateRepository {
    CompletionStage<Void>updateStatus(String deviceId, DeviceStatus status);
}
