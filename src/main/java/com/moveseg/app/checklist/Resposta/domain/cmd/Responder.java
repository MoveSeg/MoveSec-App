package com.moveseg.app.checklist.Resposta.domain.cmd;

import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;
import com.moveseg.app.checklist.Item.domain.ItemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Responder {
    public GrupoChecklistId grupoChecklist;
    public ChecklistId checklist;
    public ItemId item;
    public Long idUsuario;
    public Boolean resposta;
}
