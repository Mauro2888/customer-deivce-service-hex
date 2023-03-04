package customer.domain.customer.repository;

import customer.domain.customer.Customer;

import java.util.concurrent.CompletionStage;

public interface CustomerCreateRepository {
    CompletionStage<Void> create(Customer customer);
}
