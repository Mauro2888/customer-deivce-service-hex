package customer.vm.api.customer.update;

import customer.vm.common.CustomerCodiceFiscaleViewModel;
import customer.vm.customer.update.AddressViewModel;

import java.util.concurrent.CompletionStage;

public interface UpdateCustomerAddressResource {
    CompletionStage<Void> update(CustomerCodiceFiscaleViewModel codiceFiscale, AddressViewModel addressViewModel);
}
