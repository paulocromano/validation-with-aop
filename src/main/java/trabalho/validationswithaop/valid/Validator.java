package trabalho.validationswithaop.valid;

import trabalho.validationswithaop.valid.validations.SizeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validator {

    Class<? extends Valid> using();
}
