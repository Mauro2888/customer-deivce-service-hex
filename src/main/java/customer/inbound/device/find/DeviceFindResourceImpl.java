package customer.inbound.device.find;

import customer.inbound.customer.create.Delegate;
import customer.inbound.exception.ExceptionHandlerRest;
import customer.vm.api.device.find.DeviceFindResource;
import customer.vm.device.find.DeviceViewModel;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.annotation.RegisterProviders;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

@Path("api/v1/device/{id}")
@RegisterProvider(ExceptionHandlerRest.class)
public class DeviceFindResourceImpl implements DeviceFindResource {

    private final DeviceFindResource delegate;
    public DeviceFindResourceImpl(@Delegate DeviceFindResource delegate) {
        this.delegate = delegate;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public CompletionStage<DeviceViewModel> find(
            @PathParam(value = "id") UUID id) {
        return delegate.find(id);
    }
}
