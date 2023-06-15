package com.example.seckill.validator;

import com.example.seckill.vo.IsMobileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@NotNull
@Deprecated
public @interface IsMobile {

    boolean required() default true;

    String message() default "Invalid mobile number format!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
