package customer.domain.customer.create;

import customer.domain.customer.Customer;
import customer.vm.customer.create.CustomerCreateViewModel;

import java.util.concurrent.CompletionStage;

public interface CustomerCreateService {
    CompletionStage<Void> create(CustomerCreateViewModel customer);
}
