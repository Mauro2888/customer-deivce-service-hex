package customer.domain.device.find;

import customer.domain.device.Device;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

public interface DeviceFindService {
    CompletionStage<Device> find(UUID id);
}
