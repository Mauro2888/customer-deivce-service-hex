package customer.inbound.customer.create;

import customer.domain.customer.create.CustomerCreateService;
import customer.domain.customer.find.CustomerFindService;
import customer.vm.api.customer.create.CustomerCreateResource;
import customer.vm.customer.create.CustomerCreateViewModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;


@Delegate
@RequestScoped
public class CustomerCreateDelegate implements CustomerCreateResource {
    private final Logger log = Logger.getLogger(CustomerCreateDelegate.class.getName());

    private final CustomerCreateService customerCreateService;
    private final CustomerFindService customerFindService;

    @Inject
    public CustomerCreateDelegate(CustomerCreateService service, CustomerFindService customerFindService) {
        this.customerCreateService = service;
        this.customerFindService = customerFindService;
    }

    @Override
    public CompletionStage<Void> create(CustomerCreateViewModel customer) {
        log.info("create customer: %s".formatted(customer));
        var promise = customerCreateService.create(customer);
        promise.thenAccept(result -> log.info("customer created: %s".formatted(customer)));
        promise.exceptionally(exception -> {
            log.log(SEVERE,"customer creation failed: %s".formatted(exception));
            return null;
        });
        return promise;
    }
}
