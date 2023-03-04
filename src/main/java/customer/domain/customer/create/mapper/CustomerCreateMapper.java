package customer.domain.customer.create.mapper;

import customer.domain.customer.Customer;
import customer.vm.customer.create.CustomerCreateViewModel;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Function;

@ApplicationScoped
public class CustomerCreateMapper implements Function<CustomerCreateViewModel, Customer> {

    private final DeviceViewModelMapper deviceViewModelMapper;

    public CustomerCreateMapper(DeviceViewModelMapper deviceViewModelMapper) {
        this.deviceViewModelMapper = deviceViewModelMapper;
    }

    @Override
    public Customer apply(CustomerCreateViewModel customerCreateViewModel) {
        return Customer.builder()
                .withCodiceFiscale(customerCreateViewModel.codiceFiscale())
                .withNome(customerCreateViewModel.nome())
                .withCognome(customerCreateViewModel.cognome())
                .withIndirizzo(customerCreateViewModel.indirizzo())
                .withDevices(deviceViewModelMapper.apply(customerCreateViewModel.devices()))
                .build();
    }
}
