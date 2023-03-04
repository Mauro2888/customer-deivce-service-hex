package customer.domain.customer.find;

import customer.domain.customer.Customer;
import customer.domain.customer.repository.CustomerFindRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class CustomerFindServiceImpl implements CustomerFindService{

    private final CustomerFindRepository customerFindRepository;

    @Inject
    public CustomerFindServiceImpl(CustomerFindRepository customerFindRepository) {
        this.customerFindRepository = customerFindRepository;
    }

    @Override
    public CompletionStage<Customer> find(String codiceFiscale) {
        return customerFindRepository.find(codiceFiscale);
    }
}
