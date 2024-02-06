package com.moveseg.app.cadastro.cadastroInstituiocao.domain.cmd;

import com.moveseg.app.cadastro.cadastroInstituiocao.domain.Endereco;
import com.moveseg.app.cadastro.cadastroInstituiocao.domain.Responsavel;
import com.moveseg.app.cadastro.cadastroInstituiocao.domain.Telefone;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public interface cadastrarInstituto{

    @Data 
    public final class CriarCadastroInstituto{

        @NotBlank
        @Schema(required = true)
        private final String nome;

        @NotBlank
        private final Endereco endereco;

        @NotBlank
        private final Responsavel responsavel;
        
        @NotBlank
        private final Telefone telefone;
            
        @NotBlank
        private final Email email;
         


    }
}