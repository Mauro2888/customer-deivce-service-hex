package customer.vm.customer.create;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {LimitedSizeValidator.class})
public @interface LimitedSize {
    String message() default "List size exceeds maximum allowed value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int value() default 2;
}
