package customer.outbound.mapper;

import customer.domain.customer.Customer;
import customer.outbound.entity.customer.CustomerEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Function;

@ApplicationScoped
public class CustomerDomainToEntityMapper implements Function<Customer, CustomerEntity> {

    private final DevicesDomainToEntityMapper devicesDomainToEntityMapper;

    @Inject
    public CustomerDomainToEntityMapper(DevicesDomainToEntityMapper devicesDomainToEntityMapper) {
        this.devicesDomainToEntityMapper = devicesDomainToEntityMapper;
    }


    @Override
    public CustomerEntity apply(Customer customer) {
        return CustomerEntity.builder()
                .withCodiceFiscale(customer.codiceFiscale())
                .withNome(customer.nome())
                .withCognome(customer.cognome())
                .withIndirizzo(customer.indirizzo())
                .withDevices(devicesDomainToEntityMapper.apply(customer.devices()))
                .build();
    }
}
