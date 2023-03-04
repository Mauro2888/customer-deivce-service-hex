package customer.vm.api.customer.find;

import customer.vm.common.CustomerCodiceFiscaleViewModel;
import customer.vm.customer.find.CustomerFindViewModel;

import javax.validation.Valid;
import java.util.concurrent.CompletionStage;

public interface CustomerFindResource {
    CompletionStage<CustomerFindViewModel> find(@Valid CustomerCodiceFiscaleViewModel codiceFiscale);
}
