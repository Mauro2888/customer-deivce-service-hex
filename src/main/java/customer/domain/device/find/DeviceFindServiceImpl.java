package customer.domain.device.find;

import customer.domain.device.Device;
import customer.domain.device.repository.DeviceFindRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class DeviceFindServiceImpl implements DeviceFindService {

    private final DeviceFindRepository deviceFindRepository;

    @Inject
    public DeviceFindServiceImpl(DeviceFindRepository deviceFindRepository) {
        this.deviceFindRepository = deviceFindRepository;
    }

    @Override
    public CompletionStage<Device> find(UUID id) {
        return deviceFindRepository.find(id);
    }
}
