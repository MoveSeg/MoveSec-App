package com.moveseg.app.cadastro.Veiculo.Infra;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.veiculo.infra.ChassiValidator;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import jakarta.validation.ConstraintValidatorContext;

public class ChassiValidatorTest {

   private ChassiValidator validator = new ChassiValidator();
   private ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

   @Test
   void ChassiValido() {
      String chassiValido = "ABCD1234567899AAA";
      assertTrue(validator.isValid(chassiValido, constraintValidatorContext));

   }

   @Test
   void ChassiInvalido() {
      String chassiInvalido = "000000007";
      assertFalse(validator.isValid(chassiInvalido, constraintValidatorContext));
   }

}