package br.com.randrade.api.dtos.consultas;

import br.com.randrade.api.enums.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull Long idConsulta,
        @NotNull MotivoCancelamento motivo
) {
}
