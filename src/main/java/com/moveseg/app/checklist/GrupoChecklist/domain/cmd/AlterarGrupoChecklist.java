package com.moveseg.app.checklist.GrupoChecklist.domain.cmd;

import java.util.List;

import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.Checklist.domain.Nome;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarGrupoChecklist {
    public GrupoChecklistId id;
    public Nome nome;
    public List<ChecklistId> checklists;
}
