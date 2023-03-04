package customer.vm.customer.create;

import customer.vm.device.find.DeviceViewModel;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

@ApplicationScoped
public class LimitedSizeValidator implements ConstraintValidator<LimitedSize, Set<DeviceViewModel>> {
    private int value;

    @Override
    public void initialize(LimitedSize constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Set<DeviceViewModel> devices, ConstraintValidatorContext context) {
        return devices.size() <= value;
    }
}
