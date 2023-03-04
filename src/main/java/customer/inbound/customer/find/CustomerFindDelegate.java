package customer.inbound.customer.find;

import customer.domain.customer.find.CustomerFindService;
import customer.inbound.customer.create.Delegate;
import customer.inbound.customer.find.mapper.CustomerDomainToViewModelMapper;
import customer.vm.api.customer.find.CustomerFindResource;
import customer.vm.common.CustomerCodiceFiscaleViewModel;
import customer.vm.customer.find.CustomerFindViewModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@RequestScoped
@Delegate
public class CustomerFindDelegate implements CustomerFindResource {

    private final Logger log = Logger.getLogger(CustomerFindDelegate.class.getName());

    private final CustomerFindService customerFindService;
    private final CustomerDomainToViewModelMapper customerDomainToViewModelMapper;

    @Inject
    public CustomerFindDelegate(CustomerFindService customerFindService, CustomerDomainToViewModelMapper customerDomainToViewModelMapper) {
        this.customerFindService = customerFindService;
        this.customerDomainToViewModelMapper = customerDomainToViewModelMapper;
    }

    @Override
    public CompletionStage<CustomerFindViewModel> find(CustomerCodiceFiscaleViewModel codiceFiscale) {
        var promise = customerFindService.find(codiceFiscale.codiceFiscale())
                .thenApply(customerDomainToViewModelMapper);
        promise.thenAccept(result -> log.info("find customer with id : %s".formatted(codiceFiscale)));
        promise.exceptionally(exception -> {
            log.severe("failed to find customer: %s".formatted(exception));
            return null;
        });
        return promise;
    }
}
