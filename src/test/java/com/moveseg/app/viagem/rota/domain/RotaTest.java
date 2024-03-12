package com.moveseg.app.viagem.rota.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class RotaTest {
    private Numero numero;
    private Endereco endereco;
    private List<Endereco> enderecos;

    private Numero novoNumero;
    private List<Endereco> novosEnderecos;

    @Test
    void dadoUmaRotaCompletaDeveCriar() throws Exception {
        VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
        numero = Numero.of("317R");
        endereco = Endereco.of("Novo endereco", 9999);
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
        Rota rota = Rota.of(numero, veiculo, enderecos);

        assertNotNull(rota);
        assertNotNull(rota.id());
        assertNotNull(rota.veiculo());
        assertEquals(numero, rota.numero());
        assertEquals(enderecos, rota.enderecos());
    }

    @Test
    void dadoUmaRotaSemNumeroNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
        numero = Numero.of(null);
        endereco = Endereco.of("Novo endereco", 9999);
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
            Rota.of( numero, veiculo, enderecos);
        });
    }

    @Test 
    void dadoUmaRotaSemEnderecoNaoDeveCriar(){
        assertThrows(Exception.class, () -> {
        numero = Numero.of("317R");
        endereco = Endereco.of("Novo endereco", 9999);
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
            VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
            Rota.of( numero, veiculo, null );
    });
}

@Test 
    void dadoUmaRotaInvalidaNaoDeveCriar(){
        assertThrows(Exception.class, () -> {
            Rota.of( null, null, null);
    });
}
}