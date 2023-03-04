package customer.domain.device.update;

import customer.domain.common.DeviceStatus;
import customer.domain.device.repository.DeviceUpdateRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@ApplicationScoped
public class UpdateDeviceStatusServiceImpl implements UpdateDeviceStatusService {

    private final Logger log = Logger.getLogger(UpdateDeviceStatusServiceImpl.class.getName());

    private final DeviceUpdateRepository deviceUpdateRepository;

    public UpdateDeviceStatusServiceImpl(DeviceUpdateRepository deviceUpdateRepository) {
        this.deviceUpdateRepository = deviceUpdateRepository;
    }

    @Override
    public CompletionStage<Void> update(String deviceId, DeviceStatus status) {
        log.info("update device status: %s".formatted(status.name()));
        return deviceUpdateRepository.updateStatus(deviceId, status);
    }
}
