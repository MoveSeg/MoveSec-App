package com.moveseg.app.cadastro.Instituto.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Instituto.InstitutoBuilder;

public class IntitutoTest {

   private String nome = "Nome";
   private Endereco endereco;
   private Responsavel responsavel;
   private Telefone telefone;
   private Email email;
   private InstitutoBuilder builder;

   @BeforeEach
   void initializeBuilder() throws Exception {
      endereco = Endereco.of("logradouro", 555);
      responsavel = Responsavel.of("Nome Responsavel");
      telefone = Telefone.of(1123456 - 7890);
      email = Email.of("Exemplo@gmail.com");
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
      this.builder.nome((String) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoUmInstitutoSemEnderecoNaoDeveCriar() {
      this.builder.endereco((Endereco) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoUmInstitutoSemResponsavelNaoDeveCriar() {
      this.builder.responsavel((Responsavel) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoInstitutoUmSemTelefoneNaoDeveCriar() {
      this.builder.telefone((Telefone) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoInstitutoUmSemEmailNaoDeveCriar() {
      this.builder.email((Email) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void novasInformaçõesCompletasDeveAtulizarEManterNaoNulo() throws Exception {
      String novonome = "Novo nome";
      Endereco novoEndereco = Endereco.of("Novo endereco", 9999);
      Responsavel novoResponsavel = Responsavel.of("Responsavel novo");
      Telefone novoTelefone = Telefone.of((415555555));
      Email novoEmail = Email.of("Exemplo2@gmail.com");

      Instituto instituto = this.builder.build();
      instituto.atualizar()
            .nome(novonome)
            .endereco(novoEndereco)
            .responsavel(novoResponsavel)
            .telefone(novoTelefone)
            .email(novoEmail).aplicar();

      assertNotNull(instituto.id());
      assertEquals(novonome, instituto.nome());
      assertEquals(novoEndereco, instituto.endereco());
      assertEquals(novoResponsavel, instituto.responsavel());
      assertEquals(novoTelefone, instituto.telefone());
      assertEquals(novoEmail, instituto.email());

   }

   @Test
   void dadoNomeNuloNaoDeveAtualizar() throws Exception {
      this.builder.nome((String) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoEnderecoNuloNaoDeveAtualizar() {
      this.builder.endereco((Endereco) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoResponsavelNuloNaoDeveAtualizar() {
      this.builder.responsavel((Responsavel) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoTelefonelNuloNaoDeveAtualizar() {
      this.builder.telefone((Telefone) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }

   @Test
   void dadoEmailNuloNaoDeveAtualizar() {
      this.builder.email((Email) null);
      assertThrows(Exception.class, () -> {
         this.builder.build();
      });
   }
}
