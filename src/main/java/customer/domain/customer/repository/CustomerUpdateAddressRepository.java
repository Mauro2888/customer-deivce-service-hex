package customer.domain.customer.repository;

import customer.domain.customer.CustomerAddress;

import java.util.concurrent.CompletionStage;

public interface CustomerUpdateAddressRepository {
    CompletionStage<Void>update(String codicefiscale, CustomerAddress customerAddress);
}
