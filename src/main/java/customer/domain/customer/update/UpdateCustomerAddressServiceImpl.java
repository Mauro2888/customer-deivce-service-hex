package customer.domain.customer.update;

import customer.domain.customer.CustomerAddress;
import customer.domain.customer.repository.CustomerUpdateAddressRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class UpdateCustomerAddressServiceImpl implements UpdateCustomerAddressService{

    private final CustomerUpdateAddressRepository updateAddressRepository;
    @Inject
    public UpdateCustomerAddressServiceImpl(CustomerUpdateAddressRepository updateAddressRepository) {
        this.updateAddressRepository = updateAddressRepository;
    }

    @Override
    public CompletionStage<Void> update(String codicefiscale, CustomerAddress customerAddress) {
        return updateAddressRepository.update(codicefiscale,customerAddress);
    }
}
