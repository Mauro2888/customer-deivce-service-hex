package customer.inbound.device.update;

import customer.inbound.customer.create.Delegate;
import customer.inbound.exception.ExceptionHandlerRest;
import customer.vm.api.device.update.UpdateDeviceStatusResource;
import customer.vm.common.DeviceStatusUpdateViewModel;
import customer.vm.common.DeviceStatusViewModel;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
@RegisterProvider(ExceptionHandlerRest.class)
@Path("api/v1/device/{id}/status")
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateDeviceStatusResourceImpl implements UpdateDeviceStatusResource {

    private final UpdateDeviceStatusResource delegate;

    public UpdateDeviceStatusResourceImpl(@Delegate UpdateDeviceStatusResource delegate) {
        this.delegate = delegate;
    }

    @PATCH
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Void> update(
            @Parameter(
                    name = "id",
                    description = "Id of device",
                    required = true,
                    in = ParameterIn.PATH,
                    schema = @Schema(type = SchemaType.STRING, example = "3063a55b-141c-4470-bf70-90e2ce0b2009")
            )
            @PathParam("id")
            String deviceId,
            @RequestBody(
                    description = "Status of device",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = DeviceStatusViewModel.class),
                            examples = @ExampleObject(name = "DeviceStatusViewModel", value = "{ \"status\": \"ACTIVE\" }")
                    )
            )
            DeviceStatusUpdateViewModel status) {
        return delegate.update(deviceId, status);
    }
}
