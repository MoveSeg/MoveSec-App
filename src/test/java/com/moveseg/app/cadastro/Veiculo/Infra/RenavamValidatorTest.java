package com.moveseg.app.cadastro.Veiculo.Infra;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.veiculo.infra.RenavamValidator;

import jakarta.validation.ConstraintValidatorContext;

public class RenavamValidatorTest {

   private RenavamValidator validator = new RenavamValidator();
   private ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

   @Test
   void RenavamValido() {
      String renavamValido = "67678965432";
      assertTrue(validator.isValid(renavamValido, constraintValidatorContext));

   }

   @Test
   void RenavamInvalido() {
      String renavamInvalido = "adrfgf";
      assertFalse(validator.isValid(renavamInvalido, constraintValidatorContext));
   }

}
