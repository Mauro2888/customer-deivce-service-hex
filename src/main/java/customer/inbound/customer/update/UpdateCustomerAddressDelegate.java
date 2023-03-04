package customer.inbound.customer.update;

import customer.domain.customer.find.CustomerFindService;
import customer.domain.customer.update.UpdateCustomerAddressService;
import customer.inbound.customer.create.Delegate;
import customer.inbound.customer.find.CustomerFindDelegate;
import customer.inbound.customer.update.mapper.CustomerAddressViewModelMapper;
import customer.vm.api.customer.update.UpdateCustomerAddressResource;
import customer.vm.common.CustomerCodiceFiscaleViewModel;
import customer.vm.customer.update.AddressViewModel;

import javax.enterprise.context.RequestScoped;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

@RequestScoped
@Delegate
public class UpdateCustomerAddressDelegate implements UpdateCustomerAddressResource {

    private final Logger log = Logger.getLogger(CustomerFindDelegate.class.getName());
    private final UpdateCustomerAddressService updateCustomerAddressService;
    private final CustomerFindService customerFindService;
    private final CustomerAddressViewModelMapper customerAddressViewModelMapper;

    public UpdateCustomerAddressDelegate(UpdateCustomerAddressService updateCustomerAddressService, CustomerFindService customerFindService, CustomerAddressViewModelMapper customerAddressViewModelMapper) {
        this.updateCustomerAddressService = updateCustomerAddressService;
        this.customerFindService = customerFindService;
        this.customerAddressViewModelMapper = customerAddressViewModelMapper;
    }


    @Override
    public CompletionStage<Void> update(CustomerCodiceFiscaleViewModel codiceFiscale, AddressViewModel addressViewModel) {
        var promise = customerFindService.find(codiceFiscale.codiceFiscale())
                .thenCompose(customer ->
                        updateCustomerAddressService.update(customer.codiceFiscale(),
                                customerAddressViewModelMapper.apply(addressViewModel)));
        promise.thenAccept(result -> log.info("update customer address: %s".formatted(codiceFiscale)));
        promise.exceptionally(exception -> {
            log.log(SEVERE, "update customer address failed: %s".formatted(exception));
            return null;
        });
        return promise;
    }
}
