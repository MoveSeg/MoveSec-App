package com.moveseg.app.viagem.Programacao.app.view;

import java.time.LocalDateTime;
import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.viagem.Programacao.domain.Programacao;
import com.moveseg.app.viagem.Programacao.domain.ProgramacaoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramacaoListView {
    public ProgramacaoId id;
    public String viagem;
    public LocalDateTime data;

    public static ProgramacaoListView of(Programacao programacao) {
        List<Endereco> enderecos = programacao.viagem().rota().enderecos();
        Endereco primeiro = enderecos.get(0);
        Endereco ultimo = enderecos.get(enderecos.size()-1);

        LocalDateTime hora = (LocalDateTime) programacao.data();

        String rota = hora.getHour() + "h " + primeiro.logradouro() + "/" + ultimo.logradouro();

        return ProgramacaoListView.builder()
                .id(programacao.id())
                .viagem(rota)
                .data(programacao.data())
                .build();
    }
}
