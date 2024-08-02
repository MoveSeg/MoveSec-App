package com.moveseg.app.cadastro.Aluno.domain;

import com.moveseg.parent.infra.domain.DomainObjectId;

public class AlunoId extends DomainObjectId{
    //@JsonCreator
    //public AlunoId(@JsonProperty("aluno") String uuid){
      //  super(uuid);
    //}
    public AlunoId(String uuid) {
        super(uuid);
    }

}