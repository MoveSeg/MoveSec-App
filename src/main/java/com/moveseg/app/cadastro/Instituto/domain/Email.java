package com.moveseg.app.cadastro.instituto.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Email{

    private String email;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    private static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static Email of(String email) throws Exception {
        if (isValidEmail(email)) {
            return new Email(email);
        }else if (email.isEmpty()){
            throw new Exception("Email não pode estar vazio;");
        }
         else{
            return null;
        }
    }
}
