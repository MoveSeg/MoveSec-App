package com.moveseg.app.cadastro.cadastroInstituicao.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.cadastroInstituicao.domain.Instituto.InstitutoBuilder;


public class IntitutoTest {

    private String nome = "Nome";
    private Endereco endereco = Endereco.of("logradouro dddd", 555);
    private Responsavel responsavel = Responsavel.of("Nome Responsavel");
    private Telefone telefone = Telefone.of(1123456-7890);
    private Email email = Email.of("Exemplo@gmail.com");
    private Instituto.InstitutoBuilder builder;

    @BeforeEach
    void initializeBuilder() {
       this.builder = Instituto.builder()
        .nome(this.nome)
        .endereco(this.endereco)
        .responsavel(this.responsavel)
        .telefone(this.telefone)
        .email(this.email);
    }
    @Test
    void dadoInstitutoCompletoDeveCriar() throws Exception {
       Instituto instituto = this.builder.build();
       assertNotNull(instituto);
       assertNotNull(instituto.id());
       assertEquals(this.nome, instituto.nome());
       assertEquals(this.endereco, instituto.endereco());
       assertEquals(this.responsavel, instituto.responsavel());
       assertEquals(this.telefone, instituto.telefone());
       assertEquals(this.email, instituto.email());
    }
    @Test
    void dadoUmInstitutoSemNomeNaoDeveCriar() {
       this.builder.nome((String)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }

    @Test
    void dadoUmInstitutoSemEnderecoNaoDeveCriar() {
       this.builder.endereco((Endereco)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }
    @Test
    void dadoUmInstitutoSemResponsavelNaoDeveCriar() {
       this.builder.responsavel((Responsavel)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }
    @Test
    void dadoInstitutoUmSemTelefoneNaoDeveCriar() {
       this.builder.telefone((Telefone)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }
    @Test
    void dadoInstitutoUmSemEmailNaoDeveCriar() {
       this.builder.email((Email)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }


    @Test
    void dadoNomeDeveAtulizarEManterNaoNulo() throws Exception {
        String novoNome = "Novo Nome";
        this.builder.nome(novoNome);
        Instituto institutoAtualizado = this.builder.build();
        assertEquals(novoNome, institutoAtualizado.nome());
    }
    @Test
    void dadoEnderecoDeveAtulizarEManterNaoNulo() throws Exception{
        Endereco novoEndereco = Endereco.of("Novo endereco", 9999);
        this.builder.endereco(novoEndereco);
        Instituto institutoAtualizado = this.builder.build();
        assertEquals(novoEndereco, institutoAtualizado.endereco());
    }
    @Test
    void dadoResponsavelDeveAtulizarEManterNaoNulo() throws Exception{
        Responsavel novoResponsavel = Responsavel.of("Responsavel novo");
        this.builder.responsavel(novoResponsavel);
        Instituto institutoAtualizado = this.builder.build();
        assertEquals(novoResponsavel, institutoAtualizado.responsavel());
    }
    @Test
    void dadoTelefoneDeveAtulizarEManterNaoNulo() throws Exception{
        Telefone novoTelefone = Telefone.of((415555555));
        this.builder.telefone(novoTelefone);
        Instituto institutoAtualizado = this.builder.build();
        assertEquals(novoTelefone, institutoAtualizado.telefone());
    }
   
    @Test
    void dadoEmailDeveAtualizarEManterNaoNulo() throws Exception{
        Email novoEmail = Email.of("Exemplo2@gmail.com");
        this.builder.email(novoEmail);
        Instituto institutoAtualizado = this.builder.build();
        assertEquals(novoEmail, institutoAtualizado.email());
    }
   @Test
     void dadoNomeNuloNaoDeveAtualizar() throws Exception{
      this.builder.nome((String)null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }
   @Test
    void dadoEnderecoNuloNaoDeveAtualizar() {
       this.builder.endereco((Endereco)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
      }
   @Test
    void dadoResponsavelNuloNaoDeveAtualizar() {
       this.builder.responsavel((Responsavel)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }
   @Test
    void dadoTelefonelNuloNaoDeveAtualizar() {
       this.builder.telefone((Telefone)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }
   @Test
    void dadoEmailNuloNaoDeveAtualizar() {
       this.builder.email((Email)null);
       assertThrows(Exception.class, () -> {
          this.builder.build();
       });
    }
}
