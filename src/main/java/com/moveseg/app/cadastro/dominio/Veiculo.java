package com.moveseg.app.infra.auth.domain;

import java.util.UUID;

import com.moveseg.parent.infra.domain.AbstractEntity;

import com.moveseg.app.infra.auth.domain.VeiculoId;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Veiculo extends AbstractEntity<VeiculoId>{
    
    private final String id;


    @NotBlank
    @Embedded
    private final Placa placa;

    @NotBlank
    private final Integer numeroDaFrota;

    @NotBlank
    @Embedded
    private final Chassi chassi;

    @NotBlank
    private final Renavam renavam;

    @NotBlank
    private final Integer ano_ou_modelo;

    @NotBlank
    private final String marca;

    @NotBlank
    private final String modelo;

    @NotBlank
    private final String corPredominante;

    @NotBlank
    private final Integer capacidadeDePassageiros;

   
        private Veiculo (Placa placa,  Integer numeroDaFrota, Chassi chassi, Renavam renavam, Integer ano_ou_modelo, String marca, 
        String modelo, String corPredominate, Integer capacidadeDePassgeiros){
        
           super(randomId(VeiuloId.class));
            this.placa = placa;

    
        }
}

    


   
   


   