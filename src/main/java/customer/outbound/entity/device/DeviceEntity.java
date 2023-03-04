package customer.outbound.entity.device;

import customer.domain.common.DeviceStatus;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "device", schema = "customers")
@NamedQueries({
        @NamedQuery(name = DeviceEntity.FIND_BY_ID, query = "SELECT d FROM DeviceEntity d WHERE d.id = :id"),
        @NamedQuery(name = DeviceEntity.UPDATE_STATUS, query = "UPDATE DeviceEntity d SET d.status = :status WHERE d.id = :id")
})
public class DeviceEntity {

    public static final String FIND_BY_ID = "FIND_BY_ID";
    public static final String UPDATE_STATUS = "UPDATE_STATUS";

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    @GeneratedValue
    private UUID id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DeviceStatus status;
    protected DeviceEntity() {}

    public DeviceEntity(UUID id, DeviceStatus status) {
        this.id = id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public static class Builder {
        private UUID id;
        private DeviceStatus status;
        public Builder() {}

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withStatus(DeviceStatus status) {
            this.status = status;
            return this;
        }
        public DeviceEntity build() {
            return new DeviceEntity(id, status);
        }
    }
    public static Builder Builder() {
        return new Builder();
    }
}
