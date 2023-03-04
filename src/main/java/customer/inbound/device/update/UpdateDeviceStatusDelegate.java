package customer.inbound.device.update;

import customer.domain.common.DeviceStatus;
import customer.domain.device.find.DeviceFindService;
import customer.domain.device.update.UpdateDeviceStatusService;
import customer.inbound.customer.create.Delegate;
import customer.vm.api.device.update.UpdateDeviceStatusResource;
import customer.vm.common.DeviceStatusUpdateViewModel;
import customer.vm.common.DeviceStatusViewModel;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@Delegate
@RequestScoped
public class UpdateDeviceStatusDelegate implements UpdateDeviceStatusResource {

    private final Logger log = Logger.getLogger(UpdateDeviceStatusDelegate.class.getName());

    private final UpdateDeviceStatusService updateDeviceStatusService;
    private final DeviceFindService deviceFindService;

    @Inject
    public UpdateDeviceStatusDelegate(UpdateDeviceStatusService updateDeviceStatusService, DeviceFindService deviceFindService) {
        this.updateDeviceStatusService = updateDeviceStatusService;
        this.deviceFindService = deviceFindService;
    }

    @Override
    public CompletionStage<Void> update(String deviceId, DeviceStatusUpdateViewModel status) {
        DeviceStatus.valueOf(status.status().name());
        var promise = deviceFindService.find(UUID.fromString(deviceId))
                .thenCompose(device -> updateDeviceStatusService.update(deviceId, DeviceStatus.valueOf(status.status().name())));
        promise.thenAccept(result -> log.info("device status updated: %s".formatted(status)));
        promise.exceptionally(exception -> {
            log.severe("device status update failed: %s".formatted(exception));
            return null;
        });
        return promise;
    }
}
