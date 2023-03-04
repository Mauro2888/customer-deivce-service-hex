package customer.vm.api.customer.create;

import customer.vm.customer.create.CustomerCreateViewModel;

import javax.validation.Valid;
import java.util.concurrent.CompletionStage;

public interface CustomerCreateResource {
    CompletionStage<Void> create(@Valid CustomerCreateViewModel customer);
}
