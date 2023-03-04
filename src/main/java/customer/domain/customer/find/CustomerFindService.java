package customer.domain.customer.find;

import customer.domain.customer.Customer;

import java.util.concurrent.CompletionStage;

public interface CustomerFindService {
    CompletionStage<Customer>find(String codiceFiscale);
}
