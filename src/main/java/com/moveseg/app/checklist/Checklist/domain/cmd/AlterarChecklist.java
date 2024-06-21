package com.moveseg.app.checklist.Checklist.domain.cmd;

import java.util.List;

import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.Checklist.domain.Nome;
import com.moveseg.app.checklist.Item.domain.ItemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarChecklist {
    public ChecklistId id;
    public Nome nome;
    public List<ItemId> itens;
}
