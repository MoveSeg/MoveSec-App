package com.moveseg.app.infra.auth.domain;

import com.moveseg.parent.infra.domain.ValueObject;
 
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public final class Chassi implements ValueObject {
    private final String montadora;
    private final String pais;
    private final Integer regiao_geografica;
    private final Integer numero_de_serie;
    private final Integer Local_da_fabrica;
    private final Integer ano_ou_modelo;


    
}
