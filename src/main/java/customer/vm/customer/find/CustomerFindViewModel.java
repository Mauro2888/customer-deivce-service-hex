package customer.vm.customer.find;

import customer.vm.device.find.DeviceViewModel;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@JsonbPropertyOrder({
        "nome",
        "cognome",
        "codiceFiscale",
        "indirizzo",
        "devices"
})
public record CustomerFindViewModel(
        @NotBlank
        String cognome,
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$")
        String codiceFiscale,
        @NotBlank
        String indirizzo,
        @NotBlank
        Set<DeviceViewModel> devices) {

    public static class Builder {
private String cognome;
        private String nome;
        private String codiceFiscale;
        private String indirizzo;
        private Set<DeviceViewModel> devices;

        public Builder() {
        }

        public Builder withCognome(String cognome) {
            this.cognome = cognome;
            return this;
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withCodiceFiscale(String codiceFiscale) {
            this.codiceFiscale = codiceFiscale;
            return this;
        }

        public Builder withIndirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
            return this;
        }

        public Builder withDevices(Set<DeviceViewModel> devices) {
            this.devices = devices;
            return this;
        }

        public CustomerFindViewModel build() {
            return new CustomerFindViewModel(cognome, nome, codiceFiscale, indirizzo, devices);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
