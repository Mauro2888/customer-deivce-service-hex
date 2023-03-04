package customer.outbound.entity.customer;

import customer.outbound.entity.device.DeviceEntity;

import javax.persistence.*;
import java.util.Set;

import static customer.outbound.entity.customer.CustomerEntity.FIND_BY_CODICE_FISCALE;
import static customer.outbound.entity.customer.CustomerEntity.UPDATE_ADDRESS;

@Entity
@Table(name = "customer", schema = "customers")
@NamedQueries({
        @NamedQuery(name = FIND_BY_CODICE_FISCALE, query = "SELECT c FROM CustomerEntity c WHERE c.codiceFiscale = :codiceFiscale"),
        @NamedQuery(name = UPDATE_ADDRESS, query = "UPDATE CustomerEntity c SET c.indirizzo = :indirizzo WHERE c.codiceFiscale = :codiceFiscale")
})
public class CustomerEntity {

    public static final String FIND_BY_CODICE_FISCALE = "FIND_BY_CODICE_FISCALE";
    public static final String UPDATE_ADDRESS = "UPDATE_ADDRESS";

    private String nome;
    private String cognome;
    @Id
    private String codiceFiscale;
    private String indirizzo;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "customer_codiceFiscale")
    private Set<DeviceEntity> devices;
    public CustomerEntity(String nome, String cognome, String codiceFiscale, String indirizzo, Set<DeviceEntity> devices) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.devices = devices;
    }
    public CustomerEntity() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Set<DeviceEntity> getDevices() {
        return devices;
    }

    public void setDevices(Set<DeviceEntity> devices) {
        this.devices = devices;
    }

    public static class Builder{
        private String nome;
        private String cognome;
        private String codiceFiscale;
        private String indirizzo;
        private Set<DeviceEntity> devices;

        public Builder() {}

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withCognome(String cognome) {
            this.cognome = cognome;
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

        public Builder withDevices(Set<DeviceEntity> devices) {
            this.devices = devices;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(nome, cognome, codiceFiscale, indirizzo, devices);
        }
    }
    public static Builder builder() {
        return new Builder();
    }
}
