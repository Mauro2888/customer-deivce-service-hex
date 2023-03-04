package customer.vm.device.find;

import customer.vm.common.DeviceStatusViewModel;

import javax.json.bind.annotation.JsonbTransient;
import java.util.UUID;

public record DeviceViewModel(
        UUID id,
        DeviceStatusViewModel status) {
    public static class Builder {
        private UUID id;
        private DeviceStatusViewModel status;

        public Builder() {
        }

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withStatus(DeviceStatusViewModel status) {
            this.status = status;
            return this;
        }

        public DeviceViewModel build() {
            return new DeviceViewModel(id, status);
        }
    }

    @JsonbTransient
    public static Builder builder() {
        return new Builder();
    }
}
