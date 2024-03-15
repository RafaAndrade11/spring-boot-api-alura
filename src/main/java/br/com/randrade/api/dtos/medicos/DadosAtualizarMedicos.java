package br.com.randrade.api.dtos.medicos;

import br.com.randrade.api.dtos.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedicos(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
