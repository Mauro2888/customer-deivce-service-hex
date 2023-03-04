package customer.inbound.customer.find;

import customer.inbound.customer.create.Delegate;
import customer.inbound.exception.ExceptionHandlerRest;
import customer.vm.api.customer.find.CustomerFindResource;
import customer.vm.common.CustomerCodiceFiscaleViewModel;
import customer.vm.customer.find.CustomerFindViewModel;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("api/v1/customer/{codiceFiscale}")
@RegisterProvider(ExceptionHandlerRest.class)
public class CustomerFindResourceImpl implements CustomerFindResource {

    private final CustomerFindResource delegate;

    @Inject
    public CustomerFindResourceImpl(@Delegate CustomerFindResource delegate) {
        this.delegate = delegate;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Cliente trovato con successo"),
            @APIResponse(responseCode = "404", description = "Cliente non trovato"),
            @APIResponse(responseCode = "400", description = "Codice fiscale non valido")
    })
    public CompletionStage<CustomerFindViewModel> find(
            @Parameter(
                    name = "codiceFiscale",
                    description = "Codice fiscale del cliente",
                    required = true,
                    in = ParameterIn.PATH,
                    schema = @Schema(type = SchemaType.STRING, pattern = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$", example = "RSSMRA80A01H501T")
            )

          @PathParam("codiceFiscale") CustomerCodiceFiscaleViewModel codiceFiscale) {
        return delegate.find(codiceFiscale);
    }
}
