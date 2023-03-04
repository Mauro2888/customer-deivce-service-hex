package customer.domain.device.repository;

import customer.domain.device.Device;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

public interface DeviceFindRepository {
    CompletionStage<Device> find(UUID id);
}
