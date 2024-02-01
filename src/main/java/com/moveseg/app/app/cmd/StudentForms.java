package com.moveseg.app.app.cmd;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

public interface StudentForms {
    
    @Data
    public final class CreateStudent {

        @NotBlank
        @Schema(required = true)
        private final String name;

    }
}
