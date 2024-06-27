package com.moveseg.app.checklist.Checklist.domain.cmd;

import java.util.List;

import com.moveseg.app.checklist.Checklist.domain.Nome;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarChecklist {
    public Nome nome;
    public List<String> itens;
}
