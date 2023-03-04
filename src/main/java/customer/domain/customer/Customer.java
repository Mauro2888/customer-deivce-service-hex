package customer.domain.customer;

import customer.domain.device.Device;

import java.util.Set;

public record Customer(
        String codiceFiscale,
        String nome,
        String cognome,
        String indirizzo,
        Set<Device> devices) {

    public static class Builder {
        private String codiceFiscale;
        private String nome;
        private String cognome;
        private String indirizzo;
        private Set<Device> devices;

        public Builder() {
        }

        public Builder withCodiceFiscale(String codiceFiscale) {
            this.codiceFiscale = codiceFiscale;
            return this;
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withCognome(String cognome) {
            this.cognome = cognome;
            return this;
        }

        public Builder withIndirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
            return this;
        }

        public Builder withDevices(Set<Device> devices) {
            this.devices = devices;
            return this;
        }

        public Customer build() {
            return new Customer(codiceFiscale, nome, cognome, indirizzo, devices);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
