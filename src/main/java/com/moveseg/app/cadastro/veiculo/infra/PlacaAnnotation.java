package com.moveseg.app.cadastro.veiculo.infra;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented 
@Constraint(validatedBy = PlacaValidator.class)
@Target ({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface PlacaAnnotation {

    String message() default "Placa invalida";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
    
}
