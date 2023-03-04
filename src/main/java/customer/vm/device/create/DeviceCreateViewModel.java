package customer.vm.device.create;

import customer.vm.common.DeviceStatusViewModel;

import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.NotNull;


public record DeviceCreateViewModel(
        @NotNull
        DeviceStatusViewModel status) {
    public static class Builder {
        private DeviceStatusViewModel status;
        public Builder() {}
        public Builder withStatus(DeviceStatusViewModel status) {
            this.status = status;
            return this;
        }

        public DeviceCreateViewModel build() {
            return new DeviceCreateViewModel(status);
        }
    }

    @JsonbTransient
    public static Builder builder() {
        return new Builder();
    }
}
