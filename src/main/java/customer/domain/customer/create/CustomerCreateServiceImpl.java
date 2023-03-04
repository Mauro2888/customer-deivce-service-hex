package customer.domain.customer.create;

import customer.domain.customer.Customer;
import customer.domain.customer.create.mapper.CustomerCreateMapper;
import customer.domain.customer.repository.CustomerCreateRepository;
import customer.vm.customer.create.CustomerCreateViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class CustomerCreateServiceImpl implements CustomerCreateService {

    private final CustomerCreateRepository repository;
    private final CustomerCreateMapper createMapper;

   @Inject
    public CustomerCreateServiceImpl(CustomerCreateRepository repository, CustomerCreateMapper createMapper) {
        this.repository = repository;
       this.createMapper = createMapper;
   }

    @Override
    public CompletionStage<Void> create(CustomerCreateViewModel customer) {
        Customer req = createMapper.apply(customer);
        return repository.create(req);
    }
}
