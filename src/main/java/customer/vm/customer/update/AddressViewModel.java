package customer.vm.customer.update;

import javax.validation.constraints.NotNull;

public record AddressViewModel(
        @NotNull
        String indirizzo) {}
