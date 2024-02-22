package com.moveseg.app.cadastro.veiculo.Infra;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.veiculo.infra.PlacaValidator;

import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidatorTest {

   private PlacaValidator validator = new PlacaValidator();
   private ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

   @Test
   void PlacaValida() {
      String placaValida = "ADS6Y66";
      assertTrue(validator.isValid(placaValida, constraintValidatorContext));

   }

   @Test
   void PlacaInvalida() {
      String placaInvalida = "123244";
      assertFalse(validator.isValid(placaInvalida, constraintValidatorContext));
   }

}
