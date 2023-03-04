package customer.vm.customer.create;

import customer.vm.device.create.DeviceCreateViewModel;
import customer.vm.device.find.DeviceViewModel;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@JsonbPropertyOrder({
        "nome",
        "cognome",
        "codiceFiscale",
        "indirizzo",
        "devices"
})
public record CustomerCreateViewModel(
        @NotBlank
        String cognome,
        @NotBlank
        String nome,
        @NotBlank
        String codiceFiscale,
        @NotBlank
        String indirizzo,
        @Size(max = 2)
        Set<DeviceCreateViewModel> devices) {

    public static class Builder {
        private String cognome;
        private String nome;
        private String codiceFiscale;
        private String indirizzo;
        private Set<DeviceCreateViewModel> devices;

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

        public Builder withDevices(Set<DeviceCreateViewModel> devices) {
            this.devices = devices;
            return this;
        }

        public CustomerCreateViewModel build() {
            return new CustomerCreateViewModel(cognome, nome, codiceFiscale, indirizzo, devices);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
