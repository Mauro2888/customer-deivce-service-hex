package customer.domain.customer.update;

import customer.domain.customer.CustomerAddress;

import java.util.concurrent.CompletionStage;

public interface UpdateCustomerAddressService {
    CompletionStage<Void> update(String codicefiscale,
                                 CustomerAddress customerAddress);
}
