package com.moveseg.app.viagem.app.view;

import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.viagem.domain.RotaId;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViagemFormView {
    private ViagemId id;
    private RotaId rota;
    private MotoristaId motorista;
    private String data;

    public static ViagemFormView of(Viagem viagem) {
        return ViagemFormView.builder()
                .id(viagem.id())
                .rota(viagem.rota())
                .motorista(viagem.motorista())
                .data(viagem.data().toString())

                .build();
    }

}