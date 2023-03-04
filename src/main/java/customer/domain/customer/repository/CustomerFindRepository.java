package customer.domain.customer.repository;

import customer.domain.customer.Customer;

import java.util.concurrent.CompletionStage;

public interface CustomerFindRepository {
    CompletionStage<Customer>find(String codiceFiscale);
}
