package customer.outbound.mapper;

import customer.domain.customer.Customer;
import customer.outbound.entity.customer.CustomerEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Function;

@ApplicationScoped
public class CustomerEntityToDomainMapper implements Function<CustomerEntity, Customer> {


    private final DevicesEntityToDomainMapper devicesEntityToDomainMapper;

    @Inject
    public CustomerEntityToDomainMapper(DevicesEntityToDomainMapper devicesEntityToDomainMapper) {
        this.devicesEntityToDomainMapper = devicesEntityToDomainMapper;
    }

    @Override
    public Customer apply(CustomerEntity customerEntity) {
        return Customer.builder()
                .withCodiceFiscale(customerEntity.getCodiceFiscale())
                .withCognome(customerEntity.getCognome())
                .withNome(customerEntity.getNome())
                .withIndirizzo(customerEntity.getIndirizzo())
                .withDevices(devicesEntityToDomainMapper.apply(customerEntity.getDevices()))
                .build();
    }
}
