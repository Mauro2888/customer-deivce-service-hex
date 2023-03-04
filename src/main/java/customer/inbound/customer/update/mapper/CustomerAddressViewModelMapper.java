package customer.inbound.customer.update.mapper;

import customer.domain.customer.CustomerAddress;
import customer.vm.customer.update.AddressViewModel;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Function;

@ApplicationScoped
public class CustomerAddressViewModelMapper implements Function<AddressViewModel, CustomerAddress> {
    @Override
    public CustomerAddress apply(AddressViewModel addressViewModel) {
        return new CustomerAddress(addressViewModel.indirizzo());
    }
}
