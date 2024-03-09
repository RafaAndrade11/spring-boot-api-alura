package br.com.randrade.api.medico;

import br.com.randrade.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedicos(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
