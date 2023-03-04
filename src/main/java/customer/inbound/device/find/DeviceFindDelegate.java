package customer.inbound.device.find;

import customer.domain.device.find.DeviceFindService;
import customer.inbound.customer.create.Delegate;
import customer.inbound.device.find.mapper.DeviceViewModelMapper;
import customer.vm.api.device.find.DeviceFindResource;
import customer.vm.device.find.DeviceViewModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.CompletionStage;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Delegate
public class DeviceFindDelegate implements DeviceFindResource {

    private final Logger log = Logger.getLogger(DeviceFindDelegate.class.getName());

    private final DeviceFindService service;
    private final DeviceViewModelMapper mapper;

    @Inject
    public DeviceFindDelegate(DeviceFindService service, DeviceViewModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public CompletionStage<DeviceViewModel> find(UUID id) {
        var promise = service.find(id)
                .thenApply(mapper);
        promise.thenAccept(device -> log.info("Found device with id %s".formatted(id)));
        promise.exceptionally(exception -> {
            log.log(Level.SEVERE, "Failed to find device with id %s".formatted(id));
            return null;
        });
        return promise;
    }
}
