package customer.inbound.customer.find.mapper;

import customer.domain.customer.Customer;
import customer.vm.customer.find.CustomerFindViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Function;

@ApplicationScoped
public class CustomerDomainToViewModelMapper implements Function<Customer, CustomerFindViewModel> {

    private final CustomerDeviceToViewModelMapper customerDeviceToViewModelMapper;

    @Inject
    public CustomerDomainToViewModelMapper(CustomerDeviceToViewModelMapper customerDeviceToViewModelMapper) {
        this.customerDeviceToViewModelMapper = customerDeviceToViewModelMapper;
    }

    @Override
    public CustomerFindViewModel apply(Customer customer) {
        return CustomerFindViewModel.builder()
                .withIndirizzo(customer.indirizzo())
                .withNome(customer.nome())
                .withCognome(customer.cognome())
                .withCodiceFiscale(customer.codiceFiscale())
                .withDevices(customerDeviceToViewModelMapper.apply(customer.devices()))
                .build();
    }
}
