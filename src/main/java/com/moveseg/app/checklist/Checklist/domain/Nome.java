package com.moveseg.app.checklist.Checklist.domain;



import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class Nome {
private String nome;

    public Nome(String nome){
        this.nome = nome;
    }

    public static Nome of(String nome) throws Exception {
        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome não pode ser nulo e nem vazio");
        }
        return new Nome(nome);
    }
}
