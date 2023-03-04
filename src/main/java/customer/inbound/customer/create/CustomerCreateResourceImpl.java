package customer.inbound.customer.create;

import customer.inbound.exception.ExceptionHandlerRest;
import customer.vm.api.customer.create.CustomerCreateResource;
import customer.vm.customer.create.CustomerCreateViewModel;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("api/v1/customer")
@RegisterProvider(ExceptionHandlerRest.class)
public class CustomerCreateResourceImpl implements CustomerCreateResource {

    private final CustomerCreateResource delegate;

    @Inject
    public CustomerCreateResourceImpl(@Delegate CustomerCreateResource delegate) {
        this.delegate = delegate;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "201",
                    description = "Cliente creato con successo",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = CustomerCreateViewModel.class),
                            examples = @ExampleObject(name = "customer", value = """
                                    {
                                       "nome": "Mario",
                                       "cognome": "Rossi",
                                       "codiceFiscale": "RSSMRA30A01H501I",
                                       "indirizzo": "Via Venezia 13",
                                       "devices": [
                                         {
                                           "id": "f5b5c0d0-5f8a-11eb-ae93-0242ac130002",
                                           "status": "ACTIVE"
                                         }
                                       ]
                                     }""")
                    )
            ),
            @APIResponse(responseCode = "400", description = "Codice fiscale non valido"),
            @APIResponse(responseCode = "409", description = "Codice fiscale già presente"),
            @APIResponse(responseCode = "500", description = "Errore interno")})
    public CompletionStage<Void> create(
            @RequestBody(
                    description = "Dati del cliente da creare",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = CustomerCreateViewModel.class),
                            examples = @ExampleObject(name = "customer", value = """
                                    {
                                       "nome": "Mario",
                                       "cognome": "Rossi",
                                       "codiceFiscale": "RSSMRA30A01H501I",
                                       "indirizzo": "Via Venezia 13",
                                       "devices": [
                                         {
                                           "status": "ACTIVE"
                                         }
                                       ]
                                     }""")
                    )
            )
            CustomerCreateViewModel customer) {
        return delegate.create(customer);
    }
}
