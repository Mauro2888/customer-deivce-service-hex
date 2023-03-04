package customer.vm.common;

import javax.validation.constraints.Pattern;

public record CustomerCodiceFiscaleViewModel(
        @Pattern(regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$", message = "Codice fiscale non valido")
        String codiceFiscale) {
}
