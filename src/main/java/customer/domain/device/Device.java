package customer.domain.device;

import customer.domain.common.DeviceStatus;
import customer.domain.customer.Customer;

import javax.persistence.ManyToOne;
import java.util.UUID;

public class Device {
    private UUID id;
    private DeviceStatus status;
    public Device(UUID id, DeviceStatus status) {
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

    public static class Builder{
        private UUID id;
        private DeviceStatus status;

        public Builder(){}

        public Builder withId(UUID id){
            this.id = id;
            return this;
        }

        public Builder withStatus(DeviceStatus status){
            this.status = status;
            return this;
        }

        public Device build(){
            return new Device(id, status);
        }
    }
    public static Builder builder(){
        return new Builder();
    }

}
