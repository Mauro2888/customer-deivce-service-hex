package customer.inbound.customer.update;

import customer.inbound.customer.create.Delegate;
import customer.vm.api.customer.update.UpdateCustomerAddressResource;
import customer.vm.common.CustomerCodiceFiscaleViewModel;
import customer.vm.common.DeviceStatusViewModel;
import customer.vm.customer.update.AddressViewModel;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("api/v1/customer/{codiceFiscale}/address")
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateCustomerAddressResourceImpl implements UpdateCustomerAddressResource {

    private final UpdateCustomerAddressResource delegate;

    @Inject
    public UpdateCustomerAddressResourceImpl(@Delegate UpdateCustomerAddressResource delegate) {
        this.delegate = delegate;
    }

    @PATCH
    @Override
    public CompletionStage<Void> update(
            @Parameter(
                    name = "codiceFiscale",
                    description = "codiceFiscale of customer",
                    required = true,
                    in = ParameterIn.PATH,
                    schema = @Schema(type = SchemaType.STRING, example = "RSSMRA80A01H501T")
            )
            @PathParam(value = "codiceFiscale")
            CustomerCodiceFiscaleViewModel codiceFiscale,
            @RequestBody(
                    description = "Address of customer",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = AddressViewModel.class),
                            examples = @ExampleObject(name = "AddressViewModel", value = "{ \"indirizzo\": \"Via Roma\" }")
                    )
            )
            AddressViewModel addressViewModel) {
        return delegate.update(codiceFiscale, addressViewModel);
    }
}
