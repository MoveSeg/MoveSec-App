package com.moveseg.app.cadastro.veiculo.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ChassiValidator implements ConstraintValidator<ChassiAnnotation, String>{


    public boolean isValid (String chassi,  ConstraintValidatorContext context){ 
    String chassiAlfanumerica = chassi.replaceAll("[^a-zA-Z0-9]", "");

    return chassiAlfanumerica.matches("[A-HJ-NPR-Z0-9]{17}");
}
}
