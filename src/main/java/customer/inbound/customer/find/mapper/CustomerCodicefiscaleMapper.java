package customer.inbound.customer.find.mapper;

import customer.vm.common.CustomerCodiceFiscaleViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Function;

@ApplicationScoped
public class CustomerCodicefiscaleMapper implements Function<CustomerCodiceFiscaleViewModel,String> {
    @Override
    public String apply(CustomerCodiceFiscaleViewModel customerCodiceFiscaleViewModel) {
        return customerCodiceFiscaleViewModel.codiceFiscale();
    }
}
